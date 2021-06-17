package com.tucasitatasaciones.tucasitatasaciones.services;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.DistrictNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IDistrictRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithPriceDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithSquareMeterDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.mappers.OwnershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OwnershipService implements IOwnershipService {

    @Autowired
    private IOwnerRepository ownerRepository;

    @Autowired
    private IDistrictRepository districtRepository;

    @Override
    public OwnershipWithDataDTO add(OwnershipWithDataDTO ownership) throws DistrictNotFoundException {
        var entity = OwnershipMapper.dtoToEntity(ownership);

        var district = districtRepository.findAny(entity.getDistrictId());

        if (Objects.isNull(district)) throw new DistrictNotFoundException(entity.getDistrictId());

        entity.setId(ownerRepository.add(entity));

        var result  = OwnershipMapper.entityToOwnershipWithDataDTO(entity);
        result.setDistrict(OwnershipMapper.districtDtoTODistrict(district));

        return result;
    }

    @Override
    public OwnershipWithSquareMeterDTO calculateSquareMeterByOwnership(int ownershipId) throws OwnershipNotFoundException {
        double squareMeters = 0D;

        Ownership entity = ownerRepository.findFirst(ownershipId);
        if (entity == null) throw new OwnershipNotFoundException(ownershipId);

        squareMeters = calculateSquareMeter(entity.getRooms());

        var result = OwnershipMapper.entityToOwnershipWithSquareMeterDTO(entity);
        result.setSquareMeter(squareMeters);

        return result;
    }

    @Override
    public OwnershipWithPriceDTO calculatePriceByOwnership(int ownershipId) throws DistrictNotFoundException, OwnershipNotFoundException {
        Ownership entity = ownerRepository.findFirst(ownershipId);

        if (entity == null) throw new OwnershipNotFoundException(ownershipId);

        var district = districtRepository.findAny(entity.getDistrictId());

        if (Objects.isNull(district)) throw new DistrictNotFoundException(entity.getDistrictId());

        double squareMeters = calculateSquareMeter(entity.getRooms());

        var result = OwnershipMapper.entityToOwnershipWithPriceDTO(entity);
        result.setPrice(squareMeters * district.getPrice());

        return result;
    }

    private double calculateSquareMeter(List<Room> rooms) {
        double result = 0D;
        for (Room room : rooms) {
            result = result + room.getHigh() * room.getWidth();
        }
        return result;
    }
}
