package com.example.APIStudent.controller;

import com.example.APIStudent.repository.Student;
import com.example.APIStudent.services.IStudentService;
import com.example.APIStudent.services.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @PostMapping("/info")
        public StudentDTO getCertificate(@RequestBody Student student){
            return iStudentService.getCertificate(student);
        }

}
