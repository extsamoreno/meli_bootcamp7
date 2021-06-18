package com.tucasita.tasaciones.project.controllers;

import com.tucasita.tasaciones.project.exceptions.PropertyAlreadyExistsException;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.services.Dto.PropertyDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyEnvironmentDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyTotalSquareMetersDto;
import com.tucasita.tasaciones.project.services.Dto.PropertyValueDto;
import com.tucasita.tasaciones.project.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    //Calculate the total square meters of a property
    @GetMapping("/{propertyName}/meters")
    public ResponseEntity<PropertyTotalSquareMetersDto> getTotalSquareMeters(@PathVariable String propertyName) throws PropertyNameNotFoundException {
       return new ResponseEntity<>(iPropertyService.getTotalSquareMeters(propertyName), HttpStatus.OK);
    }

    //Get property value
    @GetMapping("/{propertyName}/value")
    public ResponseEntity<PropertyValueDto> getPropertyValue(@PathVariable String propertyName) throws PropertyNameNotFoundException, PropertyDistrictNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getPropertyValue(propertyName),HttpStatus.OK);
    }

    //Get biggest environment
    @GetMapping("/{propertyName}/environment/biggest")
    public ResponseEntity<PropertyEnvironmentDto> getBiggestEnvironment (@PathVariable String propertyName) throws PropertyNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getBiggestEnvironment(propertyName),HttpStatus.OK);
    }

    //Get list of environment sizes
    @GetMapping("/{propertyName}/environment/sizelist")
    public ResponseEntity<ArrayList<PropertyEnvironmentDto>> getEnvironmentSizesList (@PathVariable String propertyName) throws PropertyNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getEnvironmentSizesList(propertyName),HttpStatus.OK);
    }

    //Add new property
    @PostMapping("/newproperty")
    public ResponseEntity<?> addNewProperty (@Valid @RequestBody PropertyDto propertyDto) throws PropertyAlreadyExistsException, PropertyDistrictNameNotFoundException {
        this.iPropertyService.addNewProperty(propertyDto);
        ArrayList<String> response = new ArrayList<>();
        response.add("The property named: "+propertyDto.getProp_name()+" has been succesfully created");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
