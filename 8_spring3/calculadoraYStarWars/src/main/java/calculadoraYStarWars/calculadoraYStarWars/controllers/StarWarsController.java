package calculadoraYStarWars.calculadoraYStarWars.controllers;

import calculadoraYStarWars.calculadoraYStarWars.dto.PersonajeRequestDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PersonajeResponseDTO;
import calculadoraYStarWars.calculadoraYStarWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    PersonajeService personajeService;

    @PostMapping("/personaje/buscarPorNombre")
    public ResponseEntity<ArrayList<PersonajeResponseDTO>> obtenerPersonajes(@RequestBody PersonajeRequestDTO personaje) {
        return new ResponseEntity(personajeService.obtenerPersonajesPorNombre(personaje), HttpStatus.OK);
    }
}
