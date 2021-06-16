package com.tucasitatasaciones.tucasitatasaciones.services;

import com.tucasitatasaciones.tucasitatasaciones.repositories.IDistrictRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithPriceDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithSquareMeterDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.mappers.OwnershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnershipService implements IOwnershipService {

    @Autowired
    private IOwnerRepository ownerRepository;

    @Autowired
    private IDistrictRepository districtRepository;

    @Override
    public OwnershipWithDataDTO add(OwnershipWithDataDTO ownership) {

        Ownership entity = OwnershipMapper.dtoToEntity(ownership);
        
        Ownership result = ownerRepository.add(new Ownership());
        return null;
    }

    @Override
    public OwnershipWithSquareMeterDTO calculateSquareMeterByOwnership(int ownershipId) {

        Ownership result = ownerRepository.findFirst(ownershipId);

        // TODO: 16/06/2021 map entity to dto

        return null;
    }

    @Override
    public OwnershipWithPriceDTO calculatePriceByOwnership(int ownershipId) {
        Ownership result = ownerRepository.findFirst(ownershipId);

        // TODO: 16/06/2021 map entity to dto

        return null;
    }
}
