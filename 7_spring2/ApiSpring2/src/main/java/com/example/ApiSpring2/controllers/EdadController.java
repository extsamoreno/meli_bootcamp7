package com.example.ApiSpring2.controllers;

import com.example.ApiSpring2.Service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EdadController {
    EdadService service = new EdadService();
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer getEdad(@PathVariable("dia") Integer dia,@PathVariable("mes") Integer mes,@PathVariable("anio") Integer anio){
        return service.obtenerAnios(dia,mes,anio);
    }
}
