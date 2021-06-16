package com.TuCasitaTasacionesAPI.TuCasita.controllers;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.DistrictDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.services.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    IDistrictService iDistrictService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody DistrictDTO districtDTO) throws DistrictAlreadyExistsException {
        iDistrictService.create(districtDTO);
        return new ResponseEntity(HttpStatus.OK);
    }


/*
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<District> getById(@PathVariable() int id) throws DistrictNotFoundException {
        return new ResponseEntity(iDistrictService.getById(id), HttpStatus.OK);
    }

 */

}
