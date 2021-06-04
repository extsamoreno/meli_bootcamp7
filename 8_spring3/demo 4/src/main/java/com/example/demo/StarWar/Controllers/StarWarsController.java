package com.example.demo.StarWar.Controllers;

import com.example.demo.StarWar.Repository.Personaje;
import com.example.demo.StarWar.Services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buscar")
public class StarWarsController {

    @Autowired
    SearchService searchService;

    @GetMapping("/{nombre}")
    public List<Personaje> getPersonajes(@PathVariable String nombre){
        return searchService.buscar(nombre);
    }

}