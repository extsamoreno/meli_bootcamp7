package com.meli.tucasita.service;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.repository.DistrictRepositoryImpl;
import com.meli.tucasita.repository.PropertyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.meli.tucasita.mapper.PropertyMapper.mapPropertyFromDTO;
import static com.meli.tucasita.util.PropertyUtils.*;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepositoryImpl propertyRepository;

    @Autowired
    private DistrictRepositoryImpl districtRepository;

    public String getPropertyArea(List<RoomDTO> rooms) {

        return "El total de metros cuadrados de la propiedad es de " + calculatePropTotalArea(rooms) + " m2";
    }

    public String getPropertyPrice(PropertyPriceRequestDTO propertyPriceRequestDTO) throws InvalidDistrictException {

        if (districtRepository.districtNameNotExists(propertyPriceRequestDTO.getDistrict())) {
            throw new InvalidDistrictException();
        }

        double meterPrice = districtRepository.getDistrictByName(propertyPriceRequestDTO.getDistrict()).getPrice();
        double propertyMeters = calculatePropTotalArea(propertyPriceRequestDTO.getRooms());

        return "El valor total de la propiedad es de USD$ " + calculatePropertyPrice(propertyMeters, meterPrice);
    }

    public String getPropertyBiggestRoom(List<RoomDTO> roomDTOS) {

        Optional<RoomDTO> biggest = roomDTOS.stream().max(Comparator.comparing(r -> r.getWidth() * r.getLength()));
        assert biggest.orElse(null) != null;
        String biggestRoom = biggest.get().getName();
        double biggestRoomArea = biggest.get().getWidth() * biggest.get().getLength();

        return "El ambiente más grande de la propiedad es " + biggestRoom + ", que tiene un área de " + biggestRoomArea + " m2";
    }

    public List<RoomAreaDTO> getRoomsAreas(List<RoomDTO> roomsDTO) {

        return calculateRoomsDTOAreas(roomsDTO);
    }

    public String insertNewProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistsException, InvalidDistrictException {

        if (propertyRepository.propertyAlreadyExists(propertyDTO.getName())) {
            throw new PropertyAlreadyExistsException();
        }

        if (districtRepository.districtNameNotExists(propertyDTO.getDistrict())) {
            throw new InvalidDistrictException();
        }

        propertyRepository.insertNewProperty(mapPropertyFromDTO(propertyDTO));
        return "La propiedad se ha registrado correctamente";
    }
}
