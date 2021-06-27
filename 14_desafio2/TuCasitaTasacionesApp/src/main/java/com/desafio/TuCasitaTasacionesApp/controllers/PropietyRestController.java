package com.desafio.TuCasitaTasacionesApp.controllers;

import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyAlreadyExistException;
import com.desafio.TuCasitaTasacionesApp.model.service.ICrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/propieties")
public class PropietyRestController {

    ICrudService iCrudService;

    public PropietyRestController(ICrudService iCrudService) {
        this.iCrudService = iCrudService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> addNewPropiety(@Valid @RequestBody PropietyDTO propietyDTO) throws PropietyAlreadyExistException {
        return new ResponseEntity<>(iCrudService.createPropiety(propietyDTO), HttpStatus.OK);
    }
}
