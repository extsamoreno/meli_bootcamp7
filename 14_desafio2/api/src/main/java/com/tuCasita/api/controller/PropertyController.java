package com.tuCasita.api.controller;

import com.tuCasita.api.dto.*;
import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;
import com.tuCasita.api.service.contract.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @PostMapping("/totalsquaremeters")
    public ResponseEntity<PropertyWithTotalSquareMetersDTO> getTotalSquareMeters(@RequestBody @Valid PropertyDTO dto) throws DistrictNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getTotalSquareMeters(dto), HttpStatus.OK);
    }

    @PostMapping("/totalvalue")
    public ResponseEntity<PropertyWithTotalValueDTO> getTotalValue(@RequestBody @Valid PropertyDTO dto) throws DistrictNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getTotalValue(dto), HttpStatus.OK);
    }

    @PostMapping("/biggestenvironment")
    public ResponseEntity<PropertyWithBiggestEnvironmentDTO> getBiggestEnvironment(@RequestBody @Valid PropertyDTO dto) throws DistrictNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.calculateBiggestEnvironment(dto), HttpStatus.OK);
    }

    @PostMapping("/totalsquaremetersbyenvironment")
    public ResponseEntity<PropertyWithTotalSquareMetersByEnvironmentDTO> getTotalSquareMetersByEnvironment(@RequestBody @Valid PropertyDTO dto) throws DistrictNameNotFoundException {
        return new ResponseEntity<>(iPropertyService.getTotalSquareMetersByEnvironment(dto), HttpStatus.OK);
    }

}
