package starwars.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import starwars.repositories.Personaje;
import starwars.services.SearchService;

import java.util.List;

@RestController
@RequestMapping("/buscar")
public class StarwarsController {

    @Autowired
    SearchService searchService;

    @PostMapping("/{nombre}")
    public List<Personaje> getPersonajes(@PathVariable String nombre){
        return searchService.buscar(nombre);
    }

}
