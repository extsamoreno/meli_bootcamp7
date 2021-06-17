package com.example.tucasita.controller;

import com.example.tucasita.model.EnvironmentDTO;
import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
     * @return validation of property creation
     */

    @PostMapping("/addOne")
    public ResponseEntity<ResponseDTO> addOneProperty(@RequestBody @Valid PropertyDTO property) {
        return new ResponseEntity<>(propertyService.addOneProperty(property), HttpStatus.CREATED);
    }

    /**
     * Calculates the total square meters of a property
     *
     * @param idProperty the property you want to calculate its total square meters
     * @return total square meters of the property
     */

    @GetMapping("/calculateTotalSquareMeters")
    public ResponseEntity<ResponseDTO> calculatePropertyTotalSquareMeters (@RequestParam int idProperty) {
        return new ResponseEntity<>(propertyService.calculatePropertyTotalSquareMeters(idProperty), HttpStatus.OK);
    }

    /**
     * Calculates de price of a property
     *
     * @param idProperty the property you want to calculate its price
     * @return price of the property
     */

    @GetMapping("/calculatePrice")
    public ResponseEntity<ResponseDTO> calculatePropertyPrice (@RequestParam int idProperty) {
        return new ResponseEntity<>(propertyService.calculatePropertyPrice(idProperty), HttpStatus.OK);
    }

    /**
     * Retrieves the biggest environment of a property
     *
     * @param idProperty the property you want to know its biggest environment
     * @return biggest environment of the property
     */

    @GetMapping("/biggestEnvironment")
    public ResponseEntity<ResponseDTO> getBiggestEnvironment (@RequestParam int idProperty) {
        return new ResponseEntity<>(propertyService.getBiggestEnvironment(idProperty), HttpStatus.OK);
    }

    /**
     * Calculates the square meters of each environment of a property
     *
     * @param idProperty the property you want to calculate each environment square meters
     * @return list of environments with its data and square meters
     */

    @GetMapping("/calculateEnvironmentsSquareMeters")
    public ResponseEntity<List<EnvironmentDTO>> calculateEnvironmentsSquareMeters (@RequestParam int idProperty) {
        return new ResponseEntity<>(propertyService.calculateEnvironmentsSquareMeters(idProperty), HttpStatus.OK);
    }
}
