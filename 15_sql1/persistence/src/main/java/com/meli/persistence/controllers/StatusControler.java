package com.meli.persistence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusControler {

    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

}
