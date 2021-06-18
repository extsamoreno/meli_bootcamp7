package com.tucasitaTasaciones.controller;

import com.tucasitaTasaciones.dto.ResponseDTO.CalculateResponseDTO;
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

    @GetMapping("/calculatePropertyValue/{id}")
    public ResponseEntity<CalculateResponseDTO> calculatePropertyValue(@PathVariable Integer id) {
        return new ResponseEntity(iCalculateService.calculateValue(id), HttpStatus.OK);
    }

    @GetMapping("/calculatePropertyLargestRoom/{id}")
    public ResponseEntity<CalculateResponseDTO> calculatePropertyLargestRoom(@PathVariable Integer id) {
        return new ResponseEntity(iCalculateService.calculateLargestRoom(id), HttpStatus.OK);
    }

    @GetMapping("/calculateEnvironmentsSquareMeters/{id}")
    public ResponseEntity<CalculateResponseDTO> calculateEnvironmentsSquareMeters(@PathVariable Integer id) {
        return new ResponseEntity(iCalculateService.calculateEnvironmentsSquareMeters(id), HttpStatus.OK);
    }
}
