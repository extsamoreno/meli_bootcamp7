package com.example.validaciones.controllers;

import com.example.validaciones.Service.IDiplomaService;
import com.example.validaciones.ValidationException;
import com.example.validaciones.dtos.AlumnoDTO;
import com.example.validaciones.dtos.DiplomaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alumno")
public class ObtenerDiplomaController {

    @Autowired
    IDiplomaService iDiplomaService;

    @GetMapping("/nota/{id}")
    public DiplomaDTO getDiplomaById(@PathVariable("id") Integer id){
        return iDiplomaService.getDiplomaById(id);
    }

    @PostMapping("/nota")
    public DiplomaDTO getDiploma(@Valid @RequestBody AlumnoDTO alumno, BindingResult errors) throws ValidationException {
        if(errors.hasErrors()){
            throw new ValidationException(errors);
        }
        return iDiplomaService.getDiploma(alumno);
    }
}
