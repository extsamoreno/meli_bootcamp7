package com.bootcamp.tucasitatasaciones.controller;

import com.bootcamp.tucasitatasaciones.DTO.PropertyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @PostMapping("register-property")
    public ResponseEntity<?> registerProperty(@Valid @RequestBody PropertyDTO property) {

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
