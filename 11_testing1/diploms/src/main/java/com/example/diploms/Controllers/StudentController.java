package com.example.diploms.Controllers;

import com.example.diploms.Services.DTOs.ScoreDTO;
import com.example.diploms.Services.DTOs.StudentDTO;
import com.example.diploms.Services.iStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    iStudentService iStudentService;

    @PostMapping("student/averageScore")
    public ResponseEntity<ScoreDTO> getScore(@Valid @RequestBody StudentDTO student){
        return new ResponseEntity<>(iStudentService.getAverageScore(student), HttpStatus.OK);

    }
}
