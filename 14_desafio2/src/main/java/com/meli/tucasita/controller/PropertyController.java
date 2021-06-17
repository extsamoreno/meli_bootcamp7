package com.meli.tucasita.controller;

import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.dto.PropertyPriceRequestDTO;
import com.meli.tucasita.dto.RoomAreaDTO;
import com.meli.tucasita.dto.RoomsDTO;
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

        String response = propertyService.calculateUnknownPropertyArea(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/price")
    public ResponseEntity<String> calculatePropertyPrice(@Valid @RequestBody PropertyPriceRequestDTO propertyPriceRequestDTO) {

        String response = propertyService.getUnknownPropertyPrice(propertyPriceRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity<String> getBiggestRoom(@Valid @RequestBody RoomsDTO roomsDTO) {

        String response = propertyService.getUnknownPropertyBiggestRoom(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/roomsAreas")
    public ResponseEntity<List<RoomAreaDTO>> getRoomsAreas(@Valid @RequestBody RoomsDTO roomsDTO) {

        List<RoomAreaDTO> response = propertyService.getUnknownPropertyRoomsAreas(roomsDTO.getRooms());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/registerNewProperty")
    public ResponseEntity<String> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) throws PropertyAlreadyExistsException {

        String response = propertyService.insertNewProperty(propertyDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // --------------------------------------------------
    // Todo Estos son los METODOS QUE BUSCAN PROPIEDADES REGISTRADAS EN LA BD - Ver si los dejo o los saco

    /*
    @GetMapping("/squareMeters/{name}")
    public SquareMetersDTO calculateSquareMeters(@PathVariable String name) throws InvalidPropertyNameException {

        return propertyService.calculatePropertySquareMeters(name);
    }

    @GetMapping("/price/{name}")
    public PropertyPriceDTO calculatePropertyPrice(@PathVariable String name) throws InvalidPropertyNameException {

        return propertyService.getPropertyPrice(name);
    }

    @GetMapping("/biggestRoom/{name}")
    public BiggestRoomDTO getBiggestRoom(@PathVariable String name) throws InvalidPropertyNameException {

        return propertyService.getBiggestRoom(name);
    }

    @GetMapping("/roomsAreas/{name}")
    public RoomsAreasDTO getRoomsAreas(@PathVariable String name) throws InvalidPropertyNameException {

        return propertyService.getRoomsAreas(name);
    }
    */

}
