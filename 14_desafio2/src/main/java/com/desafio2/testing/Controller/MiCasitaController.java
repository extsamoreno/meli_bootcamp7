package com.desafio2.testing.Controller;


import com.desafio2.testing.Dto.AmbienteDTO;
import com.desafio2.testing.Dto.PropiedadListaAmbientesM2DTO;
import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Dto.PropiedadValorDTO;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;
import com.desafio2.testing.Repository.IUtilDB;
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
    public void crearDB(){
    IUtilDB.crearDataBase();

    }

    @PostMapping("/prueba")
    public ResponseEntity<?> registerStudent(@RequestBody @Valid BarrioModel ba) {
        //this.studentService.create(stu);
        return ResponseEntity.ok(null);
    }


    @GetMapping("/prueba2/{nombre}")
    public ResponseEntity<PropiedadM2DTO> prueba2(@PathVariable String nombre) throws PropiedadInexistenteException {

        return new ResponseEntity<>(iPropiedadService.calcularM2PropiedadDTO(nombre), HttpStatus.OK);

    }

    @GetMapping("/prueba3/{nombre}")
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

    @PostMapping("/verificarValidaciones")
    public ResponseEntity<?> verificarValidaciones (@Valid @RequestBody PropiedadModel propiedad){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
