package com.starwars.starwars.Services.Mapper;

import com.starwars.starwars.Dto.PersonajeResponseDTO;
import com.starwars.starwars.Model.PersonajeModel;
import com.starwars.starwars.Repository.PersonajeRepository;
//import com.starwars.starwars.Repository.PersonajeRepositoryImple;


import java.util.ArrayList;

public class PersonajeMapper {

    public static ArrayList<PersonajeResponseDTO> toDTO (ArrayList<PersonajeModel> personajesAConvertir){
    ArrayList<PersonajeResponseDTO> personajesDTO = new ArrayList<>();


        for (int i = 0; i <personajesAConvertir.size() ; i++) {
          PersonajeResponseDTO personajeResponse = new PersonajeResponseDTO();
          personajeResponse.setNombre(personajesAConvertir.get(i).getName());
          personajesDTO.add(personajeResponse);
        }
       return personajesDTO;
    }
}
