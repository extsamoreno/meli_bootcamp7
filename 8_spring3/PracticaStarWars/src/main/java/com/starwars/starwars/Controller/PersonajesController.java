package com.starwars.starwars.Controller;

import com.starwars.starwars.Dto.PersonajeResponseDTO;
import com.starwars.starwars.Services.PersonajeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter


@RequestMapping("/personajes")
public class PersonajesController {

    @Autowired
    PersonajeService personajeService;

   @GetMapping("/{name}")
    public ResponseEntity<ArrayList<PersonajeResponseDTO>> buscarPersonajes(@PathVariable String name){
       return new ResponseEntity<>(personajeService.buscarPersonajes(name), HttpStatus.OK);

    }







}
