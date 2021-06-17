package com.example.desafio2.controllers;

import com.example.desafio2.dtos.ResponseBiggestEnvironmentDTO;
import com.example.desafio2.dtos.ResponsePropertySquareDTO;
import com.example.desafio2.dtos.ResponsePropertyValueDTO;
import com.example.desafio2.dtos.ResponseSquareMetersEnvironmentDTO;
import com.example.desafio2.exceptions.PropertyException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    /**
     * Calculate the total square meters of the property
     * @param propertyId id of the property to calculate square meters
     * @return ResponsePropertySquareDTO that contains propertyName and totalSquareMeters
     * Response
     * 200 -> OK
     * @throws PropertyNotFoundException if there is no property with that id
     * Example: localhost:8081/properties/1/squareMeters
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{propertyId}/squareMeters")
    public ResponseEntity<ResponsePropertySquareDTO> getSquareMeters(@PathVariable int propertyId)
            throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getSquareMeters(propertyId), HttpStatus.OK);
    }

    /**
     * Calculate the value of the property
     * @param propertyId id of the property to calculate square meters
     * @return ResponsePropertyValueDTO that contains propertyName and valueOfProperty
     * Response
     * 200 -> OK
     * @throws PropertyException
     * PropertyNotFoundException if there is no property with that id
     * NeighborhoodNotFoundException if there is no property with that id
     * Example: localhost:8081/properties/1/value
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{propertyId}/value")
    public ResponseEntity<ResponsePropertyValueDTO> getPropertyValue(@PathVariable int propertyId)
            throws PropertyException {
        return new ResponseEntity<>(iPropertyService.getPropertyValue(propertyId), HttpStatus.OK);
    }

    /**
     * Calculate the value of the property
     * @param propertyId id of the property to calculate square meters
     * @return ResponseBiggestEnvironmentDTO that contains propertyName, totalSquareMeters and the environment
     * Response
     * 200 -> OK
     * @throws PropertyNotFoundException if there is no property with that id
     * Example: localhost:8081/properties/1/biggestEnvironment
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{propertyId}/biggestEnvironment")
    public ResponseEntity<ResponseBiggestEnvironmentDTO> getBiggestEnvironment(@PathVariable int propertyId)
            throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getBiggestEnvironment(propertyId), HttpStatus.OK);
    }

    /**
     * Calculate the value of the property
     * @param propertyId id of the property to calculate square meters
     * @return ResponseBiggestEnvironmentDTO that contains propertyName, totalSquareMeters and the environment
     * Response
     * 200 -> OK
     * @throws PropertyNotFoundException if there is no property with that id
     * Example: localhost:8081/properties/1/biggestEnvironment
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{propertyId}/environments/squareMeters")
    public ResponseEntity<ResponseSquareMetersEnvironmentDTO> getSquareMetersOfEnvironments(
            @PathVariable int propertyId)
            throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getSquareMetersOfEnvironments(propertyId), HttpStatus.OK);
    }
}
