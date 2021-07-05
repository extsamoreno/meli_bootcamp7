package com.muelitas.demo.controllers;

import com.muelitas.demo.dtos.DentistDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import com.muelitas.demo.services.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dentists")
@AllArgsConstructor
public class DentistController {

    private final IDentistService dentistService;

    @PostMapping
    public ResponseEntity<?> addNewDentist(@RequestBody @Valid DentistDTO dentist){
        dentistService.saveDentist(dentist);
        return ResponseEntity.ok(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<DentistDTO> getDentistById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.ok(dentistService.findDentistById(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<DentistDTO>> getAllDentists(){
        return ResponseEntity.ok(dentistService.findAllDentists());
    }
    @PutMapping
    public ResponseEntity<DentistDTO> updateDentist(@RequestBody @Valid DentistDTO dentist) throws BadRequestException {
        return ResponseEntity.ok(dentistService.updateDentist(dentist));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> updateDentist(@PathVariable Long id) throws BadRequestException {
        dentistService.deleteDentistById(id);
        return ResponseEntity.ok(null);
    }
}
