package com.example.demo.Controllers;

import com.example.demo.Services.DTO.HouseDTO;
import com.example.demo.Services.DiplomaResponseDTO;
import com.example.demo.Services.DiplomaService;
import com.example.demo.Services.House;
import com.example.demo.Services.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diplomas")
public class DiplomaController {

    @Autowired
    DiplomaService diplomaService = new DiplomaService();

    @PostMapping()
    public ResponseEntity<?> getDiploma(@RequestBody Student student){
       DiplomaResponseDTO diploma = diplomaService.getDiplomaDTO(student);
        return new ResponseEntity<>(diploma, HttpStatus.OK);
    }

}
