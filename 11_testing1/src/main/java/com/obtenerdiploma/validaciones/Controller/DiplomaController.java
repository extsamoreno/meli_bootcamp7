package com.obtenerdiploma.validaciones.Controller;

import com.obtenerdiploma.validaciones.Dto.DiplomaDTO;
import com.obtenerdiploma.validaciones.Dto.DiplomaFelicitacionDTO;
import com.obtenerdiploma.validaciones.Dto.DiplomaStandarDTO;
import com.obtenerdiploma.validaciones.Model.Alumno;
import com.obtenerdiploma.validaciones.Service.IDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/diploma")
    public class DiplomaController {

    @Autowired
    IDiplomaService iDiplomaService;

        @PostMapping("/obtenerDiploma")
        public ResponseEntity<DiplomaDTO> obtenerDiploma(@Valid @RequestBody Alumno alumno){
        return new ResponseEntity<>(iDiplomaService.entregarDiploma(alumno),HttpStatus.OK);
        }

    }


