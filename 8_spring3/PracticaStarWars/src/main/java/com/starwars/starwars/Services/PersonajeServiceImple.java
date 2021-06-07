package com.starwars.starwars.Services;


import com.starwars.starwars.Dto.PersonajeResponseDTO;
import com.starwars.starwars.Model.PersonajeModel;
import com.starwars.starwars.Repository.PersonajeRepository;
//import com.starwars.starwars.Repository.PersonajeRepositoryImple;
import com.starwars.starwars.Repository.PersonajesRepositoryImple;

import com.starwars.starwars.Services.Mapper.PersonajeMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class PersonajeServiceImple implements PersonajeService {

    @Autowired
    PersonajesRepositoryImple personajeRepositoryImple ;


    @Override
    public ArrayList<PersonajeResponseDTO> buscarPersonajes(String name) {

     List<PersonajeModel> personajes = personajeRepositoryImple.obtenerPersonajes();
     ArrayList<PersonajeModel> personajesAConvertir= new ArrayList<>();
     name=name.toUpperCase();


        for (int i = 0; i < personajes.size() ; i++) {
            String nombrePersonaje= personajes.get(i).getName();
            nombrePersonaje=nombrePersonaje.toUpperCase();

            if (nombrePersonaje.indexOf(name,0)>=0){

                personajesAConvertir.add(personajes.get(i));
            }

        }

        return PersonajeMapper.toDTO(personajesAConvertir);
    }
}

