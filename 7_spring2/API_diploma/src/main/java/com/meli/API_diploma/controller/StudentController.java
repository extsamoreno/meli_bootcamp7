package com.meli.API_diploma.controller;

import com.meli.API_diploma.dto.DiplomaDTO;
import com.meli.API_diploma.entities.Student;
import com.meli.API_diploma.service.DataBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/")
    public ResponseEntity<String> getMain() {
        String message = "Welcome to the API Diplomas";
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        DataBase.addStudent(new Student(student.getName(), student.getCourses()));
        return new ResponseEntity<>("Student Created", HttpStatus.ACCEPTED);
    }

    @GetMapping("/{nameStudent}")
    public ResponseEntity<DiplomaDTO> generateDiplomaOfStudent(@PathVariable String nameStudent) {
        return new ResponseEntity<>(DataBase.generateDiploma(nameStudent), HttpStatus.ACCEPTED);
    }
}
