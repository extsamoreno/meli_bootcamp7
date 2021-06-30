package com.example.demo.controllers;

import com.example.demo.model.Student;
import com.example.demo.services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {


    private IStudentService iStudentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        iStudentService.createStudent(student);
        return "Se creo el estudiante";
    }
}
