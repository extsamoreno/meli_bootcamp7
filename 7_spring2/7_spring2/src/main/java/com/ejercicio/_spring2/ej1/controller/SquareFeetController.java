package com.ejercicio._spring2.ej1.controller;


import com.ejercicio._spring2.ej1.dto.HouseDTO;
import com.ejercicio._spring2.ej1.dto.HouseResponseDTO;
import com.ejercicio._spring2.ej1.service.SquareFeetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class SquareFeetController {

    @PostMapping("/calculate")
    public ResponseEntity<HouseResponseDTO> calculate(@RequestBody HouseDTO house) {
        SquareFeetService calculateService = new SquareFeetService();
        HouseResponseDTO response = calculateService.calculate(house);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
