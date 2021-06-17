package com.example.demo.controllers;

import com.example.demo.DTO.ResponseBiggerEnvironmentDTO;
import com.example.demo.DTO.ResponseCalculateTotalMetersDTO;
import com.example.demo.DTO.ResponsePriceDTO;
import com.example.demo.DTO.ResponseTotalMetersByEnvironmentDTO;
import com.example.demo.entities.Property;
import com.example.demo.repositories.IPropertyRepository;
import com.example.demo.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.IterableConfigurationPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("property")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;


    @GetMapping("/calculateTotalMeters/{propertyId}")
    public ResponseEntity<ResponseCalculateTotalMetersDTO> calculateTotalMeters(@PathVariable int propertyId) throws Exception {
        ResponseCalculateTotalMetersDTO response = propertyService.getResponseCalculateTotalMetersDTO(propertyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/price/{propertyId}")
    public ResponseEntity<ResponsePriceDTO> price(@PathVariable int propertyId) throws Exception {
        ResponsePriceDTO response = propertyService.getPrice(propertyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/biggerEnvironment/{propertyId}")
    public ResponseEntity<ResponseBiggerEnvironmentDTO> biggerEnvironment(@PathVariable int propertyId) throws Exception {
        ResponseBiggerEnvironmentDTO response = propertyService.getBiggerEnvironment(propertyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/metersByEnvironment/{propertyId}")
    public ResponseEntity<ResponseTotalMetersByEnvironmentDTO> totalMetersByEnvironment(@PathVariable int propertyId) throws Exception {
        ResponseTotalMetersByEnvironmentDTO response = propertyService.getTotalMetersByEnvironment(propertyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
