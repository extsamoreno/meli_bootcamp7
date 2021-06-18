package com.meli.tucasita.service;

import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.dto.PropertyPriceRequestDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomDTO;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.repository.IDistrictRepository;
import com.meli.tucasita.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.meli.tucasita.mapper.PropertyMapper.mapPropertyFromDTO;
import static com.meli.tucasita.util.PropertyUtils.*;

@Service
public class PropertyServiceImpl implements IPropertyService {

    @Autowired
    private IPropertyRepository propertyRepository;

    @Autowired
    private IDistrictRepository districtRepository;

    /**
     * Obtains the total square meters of a property
     *
     * @param rooms A list of rooms, each with its measurements
     * @return The total square meters of a property
     */
    public String getPropertyArea(List<RoomDTO> rooms) {

        return "El total de metros cuadrados de la propiedad es de " + calculatePropTotalArea(rooms) + " m2";
    }

    /**
     * Obtains the price of a property, taking into account the number of square meters and the price
     * per square meter of the neighborhood in which the property is located
     *
     * @param propertyPriceRequestDTO An object that has the name of the neighborhood in which the property is located,
     *                                and the different rooms of the same with their respective measurements
     * @return The price of the property
     * @throws InvalidDistrictException If the neighborhood name does not match a valid neighborhood
     */
    public String getPropertyPrice(PropertyPriceRequestDTO propertyPriceRequestDTO) throws InvalidDistrictException {

        if (districtRepository.districtNameNotExists(propertyPriceRequestDTO.getDistrict())) {
            throw new InvalidDistrictException();
        }

        double meterPrice = districtRepository.getDistrictByName(propertyPriceRequestDTO.getDistrict()).getPrice();
        double propertyMeters = calculatePropTotalArea(propertyPriceRequestDTO.getRooms());

        return "El valor total de la propiedad es de USD$ " + calculatePropertyPrice(propertyMeters, meterPrice);
    }

    /**
     * Calculate the square meters of each room and return which is the largest room, with the square meters it has
     *
     * @param roomDTOS The rooms of the property, with the width and length of each
     * @return The largest room, with its name and its square meters
     */
    public String getPropertyBiggestRoom(List<RoomDTO> roomDTOS) {

        Optional<RoomDTO> biggest = roomDTOS.stream().max(Comparator.comparing(r -> r.getWidth() * r.getLength()));
        assert biggest.orElse(null) != null;
        String biggestRoom = biggest.get().getName();
        double biggestRoomArea = biggest.get().getWidth() * biggest.get().getLength();

        return "El ambiente más grande de la propiedad es " + biggestRoom + ", que tiene un área de " + biggestRoomArea + " m2";
    }

    /**
     * Gets the area of each of the rooms in a property
     *
     * @param roomsDTO The rooms of the property, with the width and length of each
     * @return The area of each of the rooms in a property
     */
    public List<RoomAreaDTO> getRoomsAreas(List<RoomDTO> roomsDTO) {

        List<RoomAreaDTO> roomAreaDTOList = new ArrayList<>();

        for (RoomDTO r : roomsDTO) {
            RoomAreaDTO roomAreaDTO = new RoomAreaDTO();
            roomAreaDTO.setArea(calculateRoomArea(r.getWidth(), r.getLength()));
            roomAreaDTO.setName(r.getName());
            roomAreaDTOList.add(roomAreaDTO);
        }
        return roomAreaDTOList;
    }

    /**
     * Insert a new property in the datastore source
     *
     * @param propertyDTO A Property, with its address and the neighborhood where it is located, and its rooms with their respective measurements
     * @return A confirmation message that the record was inserted successfully
     * @throws PropertyAlreadyExistsException If the Property you want to enter already exists in the database
     * @throws InvalidDistrictException       If the neighborhood name does not match a valid neighborhood
     */
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
