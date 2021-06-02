package com.springbootday2.springbootday2.controllers;

import com.springbootday2.springbootday2.dtos.CertificateDTO;
import com.springbootday2.springbootday2.dtos.StudentDTO;
import com.springbootday2.springbootday2.services.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO houseDTO) {
        String result = this.studentService.addStudent(houseDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{idStudent}/certificate")
    public ResponseEntity<CertificateDTO> generateCertificateByStudent(@PathVariable int idStudent) {

        CertificateDTO certificateDTO =  this.studentService.generateCertificateByStudent(idStudent);

        HttpStatus status = !Objects.isNull(certificateDTO) ? HttpStatus.OK : HttpStatus.NO_CONTENT;

        return new ResponseEntity<>(certificateDTO, status);
    }
}
