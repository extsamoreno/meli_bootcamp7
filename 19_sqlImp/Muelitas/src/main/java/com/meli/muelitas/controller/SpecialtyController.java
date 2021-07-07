package com.meli.muelitas.controller;

import com.meli.muelitas.service.ISpecialtyService;
import com.meli.muelitas.dto.SpecialtyDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("specialties")
@AllArgsConstructor
public class SpecialtyController {

    @Autowired
    ISpecialtyService specialtyService;

    @PostMapping("/newSpecialty")
    public ResponseEntity<Void> newSpecialty(@RequestBody @Valid SpecialtyDTO specialtyDTO) {
        specialtyService.createSpecialty(specialtyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyDTO>> getSpecialtyList() {
        return new ResponseEntity<>(specialtyService.getSpecialtyList(), HttpStatus.OK);
    }

}

