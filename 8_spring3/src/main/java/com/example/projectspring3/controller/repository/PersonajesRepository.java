package com.example.projectspring3.controller.repository;

import com.example.projectspring3.controller.service.CaloriesDTO;
import com.example.projectspring3.controller.service.Personajes;
import com.example.projectspring3.controller.service.PersonajesDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajesRepository implements IPersonajesRepository {
    private List<Personajes> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personajes>> typeRef = new TypeReference<>() {};
        List<Personajes> personajes = null;

        try {
            personajes = objectMapper.readValue(file,typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return personajes;

    }


    @Override
    public List<String> getPersonajeByName(String nombre) {
        List<Personajes> listaPersonajes= loadDataBase();
        List<String> listaNombres = new ArrayList<>();
        String nombrePersonaje;
        for(Personajes personaje:listaPersonajes){
            nombrePersonaje = personaje.getName();
            if(personaje.getName().contains(nombre)){
                listaNombres.add(nombrePersonaje);
            }
        }
        return listaNombres;
    }
}
