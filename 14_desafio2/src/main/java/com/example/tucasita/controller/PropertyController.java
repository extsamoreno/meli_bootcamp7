package com.example.tucasita.controller;

import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * TuCasita REST API - Properties Controller
 *
 * @author Macarena Agostina Pomerantz
 */

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    /**
     * Creates a new property in local repository
     *
     * @param property the property you want to create in local repository
     * @return
     */

    @PostMapping("/addOne")
    public ResponseEntity<ResponseDTO> addOneProperty(@RequestBody @Valid PropertyDTO property) {
        return new ResponseEntity<>(propertyService.addOneProperty(property), HttpStatus.CREATED);
    }

    /**
     * Calculates the total square meters of a property
     *
     * @param idProperty the property you want to calculate its total square meters
     * @return
     */

    @GetMapping("/calculateTotalSquareMeters")
    public ResponseEntity<ResponseDTO> calculatePropertyTotalSquareMeters (@RequestParam int idProperty) {
        return new ResponseEntity<>(propertyService.calculatePropertyTotalSquareMeters(idProperty), HttpStatus.OK);
    }

    @GetMapping("/calculatePrice")
    public ResponseEntity<ResponseDTO> calculatePropertyPrice (@RequestParam int idProperty) {
        return new ResponseEntity<>(propertyService.calculatePropertyPrice(idProperty), HttpStatus.OK);
    }
}
