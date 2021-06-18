package com.tucasitaTasaciones.controller;

import com.tucasitaTasaciones.dto.CalculateResponseDTO;
import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculateRestController {

    @Autowired
    ICalculateService iCalculateService;

    @GetMapping("/calculateSquareMeters/{id}")
    public ResponseEntity<CalculateResponseDTO> calculateSquareMeters(@PathVariable Integer id) {
        return new ResponseEntity(iCalculateService.calculateSquareMeters(id), HttpStatus.OK);
    }

    @GetMapping("/calculateValue/{id}")
    public ResponseEntity<CalculateResponseDTO> calculateValue(@PathVariable Integer id) {
        return new ResponseEntity(iCalculateService.calculateValue(id), HttpStatus.OK);
    }

    @GetMapping("/calculateLargestRoom/{id}")
    public ResponseEntity<CalculateResponseDTO> calculateLargestRoom(@PathVariable Integer id) {
        return new ResponseEntity(iCalculateService.calculateLargestRoom(id), HttpStatus.OK);
    }

    @GetMapping("/calculateEnvironments/{id}")
    public ResponseEntity<CalculateResponseDTO> calculateRoomsSquareMeters(@PathVariable Integer id) {
        return new ResponseEntity(iCalculateService.calculateEnvironments(id), HttpStatus.OK);
    }

}
