package com.bootcamp.tucasitatasaciones.controller;

import com.bootcamp.tucasitatasaciones.DTO.EnvironmentDTO;
import com.bootcamp.tucasitatasaciones.DTO.PropertyAppraisalDTO;
import com.bootcamp.tucasitatasaciones.DTO.PropertyDTO;
import com.bootcamp.tucasitatasaciones.DTO.TotalSquareMetersDTO;
import com.bootcamp.tucasitatasaciones.exception.NotFoundException;
import com.bootcamp.tucasitatasaciones.model.Property;
import com.bootcamp.tucasitatasaciones.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping("/register-property")
    public ResponseEntity<?> registerProperty(@Valid @RequestBody PropertyDTO property) throws NotFoundException {
        propertyService.registerProperty(property);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/total-square-meters/{propertyId}")
    public ResponseEntity<TotalSquareMetersDTO> getTotalSquareMeters(@PathVariable Long propertyId) throws NotFoundException {
        return new ResponseEntity<>(propertyService.getTotalSquareMeters(propertyId), HttpStatus.OK);
    }

    @GetMapping("/appraisal/{propertyId}")
    public ResponseEntity<PropertyAppraisalDTO> propertyAppraisal(@PathVariable Long propertyId) throws NotFoundException {
        return new ResponseEntity<>(propertyService.propertyAppraisal(propertyId), HttpStatus.OK);
    }

    @GetMapping("/get-biggest-environment/{propertyId}")
    public ResponseEntity<EnvironmentDTO> getBiggestEnvironment(@PathVariable Long propertyId) throws NotFoundException {
        return new ResponseEntity<>(propertyService.getBiggestEnviroment(propertyId), HttpStatus.OK);
    }



    @GetMapping("/list")
    public ResponseEntity<List<Property>> listProperties() {
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

}
