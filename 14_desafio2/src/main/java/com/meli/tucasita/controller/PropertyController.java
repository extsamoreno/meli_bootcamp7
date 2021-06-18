package com.meli.tucasita.controller;

import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.dto.PropertyPriceRequestDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomsDTO;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;

    /**
     * Obtains the total square meters of a property
     *
     * @param roomsDTO A list of rooms, each with its measurements
     * @return The total square meters of a property
     */
    @PostMapping("/squareMeters")
    public ResponseEntity<String> calculateSquareMeters(@Valid @RequestBody RoomsDTO roomsDTO) {

        String response = propertyService.getPropertyArea(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
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
    @PostMapping("/price")
    public ResponseEntity<String> calculatePropertyPrice(@Valid @RequestBody PropertyPriceRequestDTO propertyPriceRequestDTO) throws InvalidDistrictException {

        String response = propertyService.getPropertyPrice(propertyPriceRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Calculate the square meters of each room and return which is the largest room, with the square meters it has
     *
     * @param roomsDTO The rooms of the property, with the width and length of each
     * @return The largest room, with its name and its square meters
     */
    @PostMapping("/biggestRoom")
    public ResponseEntity<String> getBiggestRoom(@Valid @RequestBody RoomsDTO roomsDTO) {

        String response = propertyService.getPropertyBiggestRoom(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Gets the area of each of the rooms in a property
     *
     * @param roomsDTO The rooms of the property, with the width and length of each
     * @return The area of each of the rooms in a property
     */
    @PostMapping("/roomsAreas")
    public ResponseEntity<List<RoomAreaDTO>> getRoomsAreas(@Valid @RequestBody RoomsDTO roomsDTO) {

        List<RoomAreaDTO> response = propertyService.getRoomsAreas(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Insert a new property in the datastore source
     *
     * @param propertyDTO A Property, with its address and the neighborhood where it is located, and its rooms with their respective measurements
     * @return A confirmation message that the record was inserted successfully
     * @throws PropertyAlreadyExistsException If the Property you want to enter already exists in the database
     * @throws InvalidDistrictException       If the neighborhood name does not match a valid neighborhood
     */
    @PostMapping("/registerNewProperty")
    public ResponseEntity<String> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) throws PropertyAlreadyExistsException, InvalidDistrictException {

        String response = propertyService.insertNewProperty(propertyDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
