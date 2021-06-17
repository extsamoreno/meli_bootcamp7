package com.meli.tucasitatasaciones.controller;

import com.meli.tucasitatasaciones.dto.ResponseDTO;
import com.meli.tucasitatasaciones.service.appraisal.IAppraisalService;
import org.apache.coyote.Response;
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
    public ResponseEntity<ResponseDTO> getTotalSquareMeters(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iAppraisalService.getPropertyTotalSquareMeters(propertyId), HttpStatus.OK);
    }

    //Requirement US-0002
    @GetMapping("/getPropertyValue/{propertyId}")
    public ResponseEntity<ResponseDTO> getPropertyValue(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iAppraisalService.getPropertyValue(propertyId),HttpStatus.OK);
    }

    //Requirement US-0003
    @GetMapping("/getBiggestEnvironment/{propertyId}")
    public ResponseEntity<ResponseDTO> getBiggestEnvironment(@PathVariable Integer propertyId) {
        return new ResponseEntity<>(iAppraisalService.getBiggestEnvironment(propertyId),HttpStatus.OK);
    }
}
