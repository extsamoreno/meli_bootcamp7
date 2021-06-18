package com.desafio2.testing.Controller;


import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.BarrioNoExistException;
import com.desafio2.testing.Exception.BarrioYaExistente;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Exception.PropiedadYaRegistradaException;
import com.desafio2.testing.Utils.IUtilDB;
import com.desafio2.testing.Service.IPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController

public class MiCasitaController {

    @Autowired
    IPropiedadService iPropiedadService;


    @PostMapping("/crearPropiedad")
    public ResponseEntity<?> crearPropiedad (@Valid @RequestBody PropiedadRequestDTO propiedad) throws BarrioNoExistException, PropiedadYaRegistradaException {
        return new ResponseEntity<>(iPropiedadService.crearPropiedad(propiedad),HttpStatus.OK);
    }


    @GetMapping("/m2Propiedad/{nombre}")  //CU0001
    public ResponseEntity<PropiedadM2DTO> m2Propiedad(@PathVariable String nombre) throws PropiedadInexistenteException {
        return new ResponseEntity<>(iPropiedadService.calcularM2PropiedadDTO(nombre), HttpStatus.OK);
    }


    @GetMapping("/valorProp/{nombre}") //CU0002
    public ResponseEntity<PropiedadValorDTO> valorProp(@PathVariable String nombre) throws PropiedadInexistenteException {
        return new ResponseEntity<>(iPropiedadService.calcularValorPropiedadDTO(nombre), HttpStatus.OK);
    }


    @GetMapping("/ambienteMasGrande/{nombre}")  //CU0003
    public ResponseEntity<AmbienteDTO> ambienteMasGrande(@PathVariable String nombre) throws PropiedadInexistenteException {
        return new ResponseEntity<>(iPropiedadService.calcularAmbienteMasGrande(nombre), HttpStatus.OK);
    }


    @GetMapping("/listaM2/{nombre}") //CU0004
    public ResponseEntity<PropiedadListaAmbientesM2DTO> calcularListaAmbientesM2(@PathVariable String nombre) throws PropiedadInexistenteException {
        return new ResponseEntity<>(iPropiedadService.calcularListaAmbientesM2(nombre), HttpStatus.OK);
    }



}
