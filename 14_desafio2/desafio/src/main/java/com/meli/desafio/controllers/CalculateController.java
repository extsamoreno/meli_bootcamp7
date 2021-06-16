package com.meli.desafio.controllers;

import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.services.ICalculateService;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private ICalculateService calculateService;

    @PostMapping
    public ResponseEntity<String> addHouse(@Valid @RequestBody HouseDTO houseDTO) throws HouseAlreadyExistsException {
        return new ResponseEntity<>(URLBuilder.buildURL("calculate/getHouse", calculateService.save(houseDTO), ""), HttpStatus.OK);
    }

    @GetMapping("/getHouse/{id}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable Integer id) throws HouseNotFoundException {
        return new ResponseEntity<>(calculateService.getHouseById(id), HttpStatus.OK);
    }
}
