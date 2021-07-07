package com.meli.muelitas.controller;

import com.meli.muelitas.dto.DentistInDTO;
import com.meli.muelitas.service.IDentistService;
import com.meli.muelitas.dto.DentistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("dentists")
public class DentistController {

    @Autowired
    IDentistService dentistService;

    @PostMapping("/newDentist")
    public ResponseEntity<Void> newDentist(@RequestBody @Valid DentistInDTO dentistInDTO) {
        dentistService.createDentist(dentistInDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DentistDTO>> getDentistList() {
        return new ResponseEntity<>(dentistService.getDentistList(), HttpStatus.OK);
    }
}
