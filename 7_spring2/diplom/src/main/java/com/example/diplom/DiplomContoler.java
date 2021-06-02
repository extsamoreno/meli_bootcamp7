package com.example.diplom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiplomContoler {
    @PostMapping("/diplom")
    public ResponseEntity<Diplom> get(@RequestBody Student student){

        return new ResponseEntity<>(student.genDiplom(), HttpStatus.CREATED);
    }
}
