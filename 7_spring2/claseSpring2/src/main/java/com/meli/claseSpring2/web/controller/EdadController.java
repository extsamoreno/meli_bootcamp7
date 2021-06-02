package com.meli.claseSpring2.web.controller;

import com.meli.claseSpring2.web.response.EdadResponse;
import com.meli.claseSpring2.web.services.EdadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edad")
public class EdadController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<EdadResponse> calcularEdad(@PathVariable("dia") int pdia, @PathVariable("mes") int pmes, @PathVariable("anio") int panio){
        EdadResponse respuesta = new EdadResponse(pdia,pmes,panio,EdadService.calcularEdad(pdia,pmes,panio));
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
