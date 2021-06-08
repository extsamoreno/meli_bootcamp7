package com.example.demo.services;


import com.example.demo.dto.Personaje;
import com.example.demo.dto.PersonajeDTO;
import com.example.demo.repository.PersonajeRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImple implements PersonajeService {

    @Autowired
    PersonajeRepositoryImple personajeRepositoryImple;

    @Override
    public String cargarBD() {
        personajeRepositoryImple.obtenerPersonajes();
        return "Datos cargados";
    }

    @Override
    public List<Personaje> retornarPersonaje(String palabra) {

        List<Personaje> personajeList= new ArrayList<>();

        for(Personaje pers:personajeRepositoryImple.getPersonajesList()){
            if(pers.getName().toLowerCase().contains(palabra.toLowerCase())){
                personajeList.add(pers);
            }
        }
        return personajeList;
    }

    @Override
    public List<PersonajeDTO> retornarNombres(String palabra) {

        List<PersonajeDTO> personajeList= new ArrayList<>();

        for(Personaje pers:personajeRepositoryImple.getPersonajesList()){
            if(pers.getName().toLowerCase().contains(palabra.toLowerCase())){
                personajeList.add(new PersonajeDTO(pers.getName()));
            }
        }
        return personajeList;
    }
}
