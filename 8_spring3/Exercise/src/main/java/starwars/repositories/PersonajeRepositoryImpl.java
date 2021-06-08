package starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{


    @Override
    public List<Personaje> getMatches(String name) {

        List<Personaje> personajesDTOS = null;
        personajesDTOS = loadDataBase();
        List<Personaje> result = null;

        List<Personaje> filters = new ArrayList<>();

        if(personajesDTOS != null){
            List<Personaje> item = personajesDTOS.stream()
                    .filter(personaje -> personaje.getName().contains(name))
                    .collect(Collectors.toList());
            result = item;
        }

        return result;
    }

    public List<Personaje> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("/Users/gcaiti/Downloads/calorias/src/main/java/starwars/repositories/starwars.json");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>(){};
        List<Personaje> personajesDTOS = null;
        try{
            personajesDTOS = objectMapper.readValue(file,typeRef);
        }catch(IOException e){
            e.printStackTrace();
        }
        return personajesDTOS;
    }

}