package com.example.demo.repository;

import com.example.demo.dto.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeRepositoryImple implements PersonajeRespository{


    List<Personaje> personajesList = new ArrayList<>();

    @Override
    public void obtenerPersonajes(){
        List<Personaje> personajesbd = cargarBD();

        for(Personaje personaje:personajesbd){

                personajesList.add(personaje);
        }
    }

    @Override
    public List<Personaje> cargarBD(){
        File baseDeDatos = null;
        try {
            baseDeDatos = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeReference = new TypeReference<>() {};
        List<Personaje> personajesRepositories = null;
        try{
            personajesRepositories = objectMapper.readValue(baseDeDatos, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }
       //personajesRepositories.forEach(p->System.out.println(p));
        return personajesRepositories;
    }

}
