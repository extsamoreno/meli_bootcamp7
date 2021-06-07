package com.starwars.starwars.Repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.Model.PersonajeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
@Getter
@Setter
@NoArgsConstructor
public class PersonajesRepositoryImple implements PersonajeRepository {


    public List<PersonajeModel> obtenerPersonajes(){
        List<PersonajeModel> personajesbd = cargarBaseDeDatos();
        return personajesbd;
    }

    private List<PersonajeModel> cargarBaseDeDatos() {  //codigo del profesor que lee el archivo json
        File baseDeDatos = null;
        try {
            baseDeDatos = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeModel>> typeReference = new TypeReference<>() {};
        List<PersonajeModel> personajesRepositories = null;
        try{
           personajesRepositories = objectMapper.readValue(baseDeDatos, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }

        return personajesRepositories;
    }




}
