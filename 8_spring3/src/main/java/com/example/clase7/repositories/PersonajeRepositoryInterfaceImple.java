package com.example.clase7.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryInterfaceImple implements PersonajeRepositoryInterface {
    public PersonajeRepositoryInterfaceImple() {
    }

    public List<PersonajeRepository> cargarBaseDeDatos() {
        File baseDeDatos = null;
        try {
            baseDeDatos = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeRepository>> typeReference = new TypeReference<>() {};
        List<PersonajeRepository> personajesRepositories = null;
        try{
            personajesRepositories = objectMapper.readValue(baseDeDatos, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }

        return personajesRepositories;
    }
}
