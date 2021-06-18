package com.desafio2.testing.Controller;


import com.desafio2.testing.Dto.PropiedadRequestDTO;
import com.desafio2.testing.Exception.BarrioYaExistente;
import com.desafio2.testing.Service.IPropiedadService;
import com.desafio2.testing.Utils.IUtilDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UtilController {

    @Autowired
    com.desafio2.testing.Utils.IUtilDB IUtilDB;


    @PostMapping("/verificarValidaciones")  //  para prueba, borrar
    public ResponseEntity<?> verificarValidaciones (@Valid @RequestBody PropiedadRequestDTO propiedad){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/crearDB")
    @Valid
    public void crearDB() throws BarrioYaExistente {
        IUtilDB.crearDataBase();
    }


}
