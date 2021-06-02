package com.example.demo.ex3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {
    private ArrayList<Student> studentList = new ArrayList<>();

    private DiplomaService diplomaService = new DiplomaService();

    @PostMapping("/diploma")
    public ResponseEntity<Diploma> generateDiploma(@RequestBody Student student) {
        return ResponseEntity.ok(diplomaService.generateDiploma(student));
    }
}
