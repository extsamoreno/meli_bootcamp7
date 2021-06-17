package com.example.tucasita.controller;

import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
