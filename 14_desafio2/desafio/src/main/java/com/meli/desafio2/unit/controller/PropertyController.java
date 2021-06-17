package com.meli.desafio2.unit.controller;

import com.meli.desafio2.unit.service.dto.PropertyDTO;
import com.meli.desafio2.unit.service.dto.RoomDTO;
import com.meli.desafio2.unit.service.dto.RoomSquareMDTO;
import com.meli.desafio2.unit.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/propiedad")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    @PostMapping("/registerProperty")
    public ResponseEntity<?> registerProperty(@RequestBody @Valid PropertyDTO propertyDTO) {
        this.propertyService.create(propertyDTO);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/metros/{id}")
    public ResponseEntity<Double> calculateSquareMeters(@PathVariable Long id) {
        return new ResponseEntity<>(this.propertyService.calculateSquareMeters(id), HttpStatus.OK);
    }

    @GetMapping("/valor/{id}")
    public ResponseEntity<Double> calculateValue(@PathVariable Long id) {
        return new ResponseEntity<>(this.propertyService.calculateValue(id), HttpStatus.OK);
    }

    @GetMapping("/habMasGrande/{id}")
    public ResponseEntity<RoomDTO> getBiggestRoom(@PathVariable Long id) {
        return new ResponseEntity<>(this.propertyService.biggestRoom(id), HttpStatus.OK);
    }

    @GetMapping("/habitaciones/{id}")
    public ResponseEntity<List<RoomSquareMDTO>> squareMetersRooms(@PathVariable Long id) {
        return new ResponseEntity<>(this.propertyService.roomsWithSquareMeters(id), HttpStatus.OK);
    }

/*
    @PostMapping("/modifyStudent")
    public ResponseEntity<?> modifyStudent(@RequestBody @Valid PropertyDTO stu) {
        this.studentService.update(stu);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listStudents")
    public Set<PropertyDTO> listStudents() {
        return this.studentService.getAll();
    }*/

}
