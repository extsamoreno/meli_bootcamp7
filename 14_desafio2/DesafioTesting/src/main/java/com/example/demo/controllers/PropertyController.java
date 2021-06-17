package com.example.demo.controllers;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Property;
import com.example.demo.services.PropertyService;
import com.example.demo.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("/load")
    public void loadData(){
        propertyService.load();
    }

    @PostMapping("/add")
    public ResponseEntity<PropertyRequestDTO> addProperty(@Valid @RequestBody PropertyRequestDTO propertyRequestDTO) throws DistrictDontFoundException {
        return new ResponseEntity<>(propertyService.addProperty(propertyRequestDTO),HttpStatus.CREATED);
    }

    @GetMapping("/squaremetersProp/{propId}")
    public ResponseEntity<PropertyM2ResponseDTO> getSquareMeters(@PathVariable int propId) throws PropertyDontFoundException {
        return new ResponseEntity<>(propertyService.getMeterSquare(propId), HttpStatus.OK);
    }

    @GetMapping("/propPrice/{propId}")
    public ResponseEntity<PropertyPriceResponseDTO> getPrice(@PathVariable int propId) throws PropertyDontFoundException {
        return new ResponseEntity<>(propertyService.getPrice(propId), HttpStatus.OK);
    }

    @GetMapping("/biggestEnv/{propId}")
    public ResponseEntity<BiggestPropResponseDTO> getBiggestEnvProp(@PathVariable int propId) throws PropertyDontFoundException {
        return new ResponseEntity<>(propertyService.getBiggestEnvProp(propId), HttpStatus.OK);
    }

    @GetMapping("/squaremetersEnvs/{propId}")
    public ResponseEntity<PropertyM2EnvsResponseDTO> getSquareMetersEnv(@PathVariable int propId) throws PropertyDontFoundException {
         return new ResponseEntity<>(propertyService.getMeterSquareEnvs(propId), HttpStatus.OK);
    }

    @GetMapping("/property/{propId}")
    public ResponseEntity<Property> findPropertyById(@PathVariable int propId) throws PropertyDontFoundException {
        return new ResponseEntity<>(propertyService.findPropertyById(propId),HttpStatus.OK);
    }
}
