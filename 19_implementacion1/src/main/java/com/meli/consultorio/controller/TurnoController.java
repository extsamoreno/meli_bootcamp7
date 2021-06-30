package com.meli.consultorio.controller;

import com.meli.consultorio.dto.TurnoDTO;
import com.meli.consultorio.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    ITurnoService iTurnoService;

    @PostMapping("/agregar")
    public ResponseEntity<HttpStatus> agregarTurno(@RequestBody TurnoDTO turno) throws Exception {
        HttpStatus status= iTurnoService.agregarTurno(turno);
        return new ResponseEntity<>(status, status);
    }
}
