package com.meli.tucasitatasaciones.controller;

import com.meli.tucasitatasaciones.dto.ResponseDTO;
import com.meli.tucasitatasaciones.service.appraisal.IAppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appraisals")
public class AppraisalController {
    @Autowired
    IAppraisalService iAppraisalService;

    //Requirement US-0001
    @GetMapping("/getTotalSquareMeters/{propertyId}")
    public ResponseEntity<Double> getTotalSquareMeters(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iAppraisalService.getPropertyTotalSquareMeters(propertyId), HttpStatus.OK);
    }
}
