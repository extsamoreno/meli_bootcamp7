package com.example.Spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService stService;

    @PostMapping("/calc")
    public ResponseEntity<ResponseStudentDTO> calcStudent(@RequestBody Student s){
        return new ResponseEntity<>(stService.calcStudent(s), HttpStatus.ACCEPTED);
    }

}
