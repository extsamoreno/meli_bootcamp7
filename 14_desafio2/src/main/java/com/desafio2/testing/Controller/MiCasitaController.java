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

    @Autowired  //ver si se puede sacar este autowired
    IUtilDB IUtilDB; //crear clase utilitaria que la pueda llamar de cualquier lado static

    @Autowired
    IPropiedadService iPropiedadService;

    @GetMapping("/crearDB")
    @Valid
    public void crearDB() throws BarrioYaExistente {
    IUtilDB.crearDataBase();
    }

    @PostMapping("/verificarValidaciones")
    public ResponseEntity<?> verificarValidaciones (@Valid @RequestBody PropiedadRequestDTO propiedad){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/crearPropiedad")
    public ResponseEntity<?> crearPropiedad (@Valid @RequestBody PropiedadRequestDTO propiedad) throws BarrioNoExistException, PropiedadYaRegistradaException {
        return new ResponseEntity<>(iPropiedadService.crearPropiedad(propiedad),HttpStatus.OK);
    }





    @PostMapping("/prueba")
    public ResponseEntity<?> register(@RequestBody @Valid PropiedadRequestDTO ba) {
        return ResponseEntity.ok(null);
    }


    @GetMapping("/prueba2/{nombre}")
    public ResponseEntity<PropiedadM2DTO> prueba2(@PathVariable String nombre) throws PropiedadInexistenteException {
        return new ResponseEntity<>(iPropiedadService.calcularM2PropiedadDTO(nombre), HttpStatus.OK);

    }

    @GetMapping("/CU2/{nombre}")
    public ResponseEntity<PropiedadValorDTO> prueba3(@PathVariable String nombre) throws PropiedadInexistenteException {
        return new ResponseEntity<>(iPropiedadService.calcularValorPropiedadDTO(nombre), HttpStatus.OK);

    }
    @GetMapping("/prueba4/{nombre}")
    public ResponseEntity<AmbienteDTO> prueba4(@PathVariable String nombre) throws PropiedadInexistenteException {

        return new ResponseEntity<>(iPropiedadService.calcularAmbienteMasGrande(nombre), HttpStatus.OK);

    }

    @GetMapping("/prueba5/{nombre}")
    public ResponseEntity<PropiedadListaAmbientesM2DTO> prueba5(@PathVariable String nombre) throws PropiedadInexistenteException {
        return new ResponseEntity<>(iPropiedadService.calcularListaAmbientesM2(nombre), HttpStatus.OK);
    }



}
