package com.meli.tucasita.controller;

import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.dto.PropertyPriceRequestDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomsDTO;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.service.PropertyService;
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
    private PropertyService propertyService;

    @PostMapping("/squareMeters")
    public ResponseEntity<String> calculateSquareMeters(@Valid @RequestBody RoomsDTO roomsDTO) {

        String response = propertyService.getPropertyArea(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/price")
    public ResponseEntity<String> calculatePropertyPrice(@Valid @RequestBody PropertyPriceRequestDTO propertyPriceRequestDTO) throws InvalidDistrictException {

        String response = propertyService.getPropertyPrice(propertyPriceRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity<String> getBiggestRoom(@Valid @RequestBody RoomsDTO roomsDTO) {

        String response = propertyService.getPropertyBiggestRoom(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/roomsAreas")
    public ResponseEntity<List<RoomAreaDTO>> getRoomsAreas(@Valid @RequestBody RoomsDTO roomsDTO) {

        List<RoomAreaDTO> response = propertyService.getRoomsAreas(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/registerNewProperty")
    public ResponseEntity<String> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) throws PropertyAlreadyExistsException, InvalidDistrictException {

        String response = propertyService.insertNewProperty(propertyDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
