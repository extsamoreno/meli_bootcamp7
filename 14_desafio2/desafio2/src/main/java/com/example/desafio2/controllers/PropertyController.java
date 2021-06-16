package com.example.desafio2.controllers;

import com.example.desafio2.dtos.ResponsePropertySquareDTO;
import com.example.desafio2.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    /**
     * Calculate de total square meters of the property
     * @param propertyId id of the property to calculate square meters
     * @return ResponsePropertySquareDTO that contains houseName and totalSquareMeters
     * Response
     * 200 -> OK
     * //@throws UserNotFoundException if some of the ids are not found in the repository
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{propertyId}/squareMeters")
    public ResponseEntity<ResponsePropertySquareDTO> getSquareMeters(@PathVariable int propertyId)
            throws FileNotFoundException {
        return new ResponseEntity<>(iPropertyService.getSquareMeters(propertyId), HttpStatus.OK);
    }
}
