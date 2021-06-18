package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.EnvironmentDTO;
import com.didney.junit.tucasitatasaciones.service.IEnvironmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

    IEnvironmentService iEnvironmentService;

    public EnvironmentController(IEnvironmentService iEnvironmentService) {
        this.iEnvironmentService = iEnvironmentService;
    }

    @PostMapping("/add")
    ResponseEntity<EnvironmentDTO> addEnvironment(@RequestBody EnvironmentDTO environmentDTO) {
        return new ResponseEntity<>(iEnvironmentService.addEnvironment(environmentDTO), HttpStatus.OK);
    }

    @PostMapping("/adds")
    ResponseEntity<List<EnvironmentDTO>> addEnvironments(@RequestBody List<EnvironmentDTO> environmentDTOList) {
        return new ResponseEntity<>(iEnvironmentService.addEnvironments(environmentDTOList), HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<EnvironmentDTO>> getEnvironment() {
        return new ResponseEntity<>(iEnvironmentService.getEnvironment(), HttpStatus.OK);
    }
}
