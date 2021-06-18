package com.meli.desafio.controllers;

import com.meli.desafio.exceptions.models.DistrictAlreadyExists;
import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.DistrictRequestDTO;
import com.meli.desafio.services.IDistrictService;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private IDistrictService districtService;

    @PostMapping
    public ResponseEntity<String> addDistrict(@Valid @RequestBody DistrictRequestDTO district) throws DistrictAlreadyExists {
        return new ResponseEntity<>(URLBuilder.buildURL("district", districtService.saveDistrict(district), ""), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictDTO> getDistrict(@PathVariable Integer id) throws DistrictNotFoundException {
        return new ResponseEntity<>(districtService.getById(id), HttpStatus.OK);
    }
}
