package com.meli.testingchallenge.controllers;

import com.meli.testingchallenge.dtos.EstateAssessmentDTO;
import com.meli.testingchallenge.dtos.EstateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estate")
public class EstateController {

    @PostMapping("/assessment")
    public ResponseEntity<EstateAssessmentDTO> getAssessment(@Valid @RequestBody EstateDTO house){
//        System.out.println("house.toString() = " + house.toString());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
