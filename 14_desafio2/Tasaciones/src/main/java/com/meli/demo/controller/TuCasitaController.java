package com.meli.demo.controller;


import com.meli.demo.dto.HouseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.service.ITuCasitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tucasita")
public class TuCasitaController {
    @Autowired
    ITuCasitaService iTuCasitaService;

    @PostMapping("/insertCasita")
    public ResponseEntity<Boolean> newCasita(@RequestBody @Valid HouseDTO houseDTO) throws PriceIncorrectException, NeighborhoodNotFounException, HouseExistException {
        return new ResponseEntity<>(iTuCasitaService.newCasita(houseDTO), HttpStatus.OK);
    }




}
