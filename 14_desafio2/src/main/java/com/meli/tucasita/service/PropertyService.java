package com.meli.tucasita.service;

import com.meli.tucasita.dto.*;
import com.meli.tucasita.exception.InvalidPropertyNameException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.models.Property;
import com.meli.tucasita.models.Room;
import com.meli.tucasita.repository.DistrictRepository;
import com.meli.tucasita.repository.PropertyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private DistrictRepository districtRepository;

    public String calculateUnknownPropertyArea(List<RoomDTO> rooms) {

        return "El total de metros cuadrados de la propiedad es de " + calculatePropTotalArea(rooms) + " m2";
    }

    public String getUnknownPropertyPrice(PropertyPriceRequestDTO propertyPriceRequestDTO) {

        double meterPrice = districtRepository.getDistrictByName(propertyPriceRequestDTO.getDistrict()).getPrice();
        double propertyMeters = calculatePropTotalArea(propertyPriceRequestDTO.getRooms());

        return "El valor total de la propiedad es de USD$ " + calculatePropertyPrice(propertyMeters, meterPrice);
    }

    public String getUnknownPropertyBiggestRoom(List<RoomDTO> roomDTOS) {

        Optional<RoomDTO> biggest = roomDTOS.stream().max(Comparator.comparing(r -> r.getWidth() * r.getLength()));
        String biggestRoom = biggest.get().getName();
        double biggestRoomArea = biggest.get().getWidth() * biggest.get().getLength();

        return "El ambiente más grande de la propiedad es " + biggestRoom + ", que tiene un área de " + biggestRoomArea + " m2";
    }

    public List<RoomAreaDTO> getUnknownPropertyRoomsAreas(List<RoomDTO> roomsDTO) {

        return calculateRoomsDTOAreas(roomsDTO);
    }

    public String insertNewProperty(PropertyDTO propertyDTO) throws PropertyAlreadyExistsException {

        if(!propertyRepository.propertyNotExists(propertyDTO.getName())){
            throw new PropertyAlreadyExistsException();
        }


        propertyRepository.insertNewProperty(mapPropertyFromDTO(propertyDTO));
        return "La propiedad se ha registrado correctamente";
    }


// --------------------------------------------------
// METODOS QUE BUSCAN PROPIEDADES REGISTRADAS EN LA BD
// TODO Ver si los dejo o los saco


    /*
    public SquareMetersDTO calculatePropertySquareMeters(String address) throws InvalidPropertyNameException {

        SquareMetersDTO squareMetersDTO = new SquareMetersDTO();

        if (propertyRepository.propertyNotExists(address)) {
            throw new InvalidPropertyNameException();
        }

        Property property = propertyRepository.getPropertyByName(address);

        squareMetersDTO.setAddress(address);
        squareMetersDTO.setSquareMeters(calculateTotalArea(property.getRooms()));

        return squareMetersDTO;
    }

    public PropertyPriceDTO getPropertyPrice(String address) throws InvalidPropertyNameException {

        if (propertyRepository.propertyNotExists(address)) {
            throw new InvalidPropertyNameException();
        }

        PropertyPriceDTO propertyPriceDTO = new PropertyPriceDTO();
        Property property = propertyRepository.getPropertyByName(address);
        String district = property.getDistrict();

        double meterPrice = districtRepository.getDistrictByName(district).getPrice();
        double totalMeters = calculateTotalArea(property.getRooms());

        propertyPriceDTO.setAddress(address);
        propertyPriceDTO.setDistrict(district);
        propertyPriceDTO.setMeters(totalMeters);
        propertyPriceDTO.setMeterPrice(meterPrice);
        propertyPriceDTO.setPropertyPrice(calculatePropertyPrice(totalMeters, meterPrice));

        return propertyPriceDTO;
    }

    public BiggestRoomDTO getBiggestRoom(String address) throws InvalidPropertyNameException {

        BiggestRoomDTO biggestRoomDTO = new BiggestRoomDTO();

        if (propertyRepository.propertyNotExists(address)) {
            throw new InvalidPropertyNameException();
        }

        List<Room> rooms = propertyRepository.getPropertyByName(address).getRooms();
        biggestRoomDTO.setAddress(address);

        return calculateBiggestRoom(biggestRoomDTO, rooms);
    }

    public RoomsAreasDTO getRoomsAreas(String address) throws InvalidPropertyNameException {

        RoomsAreasDTO roomsAreasDTO = new RoomsAreasDTO();

        if (propertyRepository.propertyNotExists(address)) {
            throw new InvalidPropertyNameException();
        }

        roomsAreasDTO.setAddress(address);
        roomsAreasDTO.setRooms(calculateRoomsAreas(propertyRepository.getPropertyByName(address).getRooms()));

        return roomsAreasDTO;
    }
*/

}
