package com.example.ApiSpring2.controllers;

import com.example.ApiSpring2.Repositories.AlumnosNotasRepository;
import com.example.ApiSpring2.Service.DiplomaService;
import com.example.ApiSpring2.dtos.AlumnoDTO;
import com.example.ApiSpring2.dtos.DiplomaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    DiplomaService service = new DiplomaService();
    @GetMapping("/nota/{id}")
    public DiplomaDTO getDiploma(@PathVariable("id") Integer id){
        return service.getDiploma(id);
    }

}
