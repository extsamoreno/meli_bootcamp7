package meli.star.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import meli.star.demo.dto.StarwarsjDTO;
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
@Setter
@Getter
public class StarWarsRepository {

    List<String> list = new ArrayList<>();

    public void obtenerDatos(){


        List<StarwarsjDTO> Nombres = cargarBaseDeDatos();

        for (int i = 0; i < Nombres.size(); i++) {
            list.add(Nombres.get(i).getName());
        }


    }
    public List<StarwarsjDTO> cargarBaseDeDatos() {
        File baseDeDatos = null;
        try {
            baseDeDatos = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarwarsjDTO>> typeReference = new TypeReference<>() {};
        List<StarwarsjDTO> personasRepositories = null;
        try{
            personasRepositories = objectMapper.readValue(baseDeDatos, typeReference);
        } catch (IOException e){
            e.printStackTrace();
        }

        return personasRepositories;
    }

}
