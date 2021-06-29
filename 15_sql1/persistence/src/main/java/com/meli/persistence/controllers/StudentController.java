package com.meli.persistence.controllers;

import com.meli.persistence.dtos.StudentDTO;
import com.meli.persistence.dtos.StudentsDTO;
import com.meli.persistence.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO student){
        return new ResponseEntity<String>(studentService.add(student), HttpStatus.OK);
    }

    @GetMapping("/getlist")
    public ResponseEntity<StudentsDTO> getStudents(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "perpage", defaultValue = "10")
            int perPage){
        return new ResponseEntity<StudentsDTO>(studentService.getAll(page, perPage), HttpStatus.OK);
    };
}
