package starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starwars.repositories.Personaje;
import starwars.services.SearchService;

import java.util.List;

@RestController
@RequestMapping("/buscar")
public class StarwarsController {

    @Autowired
    SearchService searchService;

    @PostMapping()
    public List<Personaje> getPersonajes(@RequestBody String nombre){
        return searchService.buscar(nombre);
    }

}