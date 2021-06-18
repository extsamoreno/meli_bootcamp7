package com.meli.desafio2.web.controller;

import com.meli.desafio2.web.dto.request.DistrictDTO;
import com.meli.desafio2.web.exception.DistrictAlreadyExistException;
import com.meli.desafio2.web.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/district/")
public class DistrictController {
    @Autowired
    IDistrictService iDistrictService;

    @GetMapping("/getdistrict/{name}")
    public ResponseEntity<DistrictDTO> getDistrict(@PathVariable("name") String name){
        return new ResponseEntity<>(iDistrictService.getDistrictByName(name), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveDistrict(@Valid @RequestBody DistrictDTO districtDTO) throws DistrictAlreadyExistException {
        iDistrictService.save(districtDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
