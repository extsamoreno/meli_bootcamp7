package com.example.clase7.services;

import com.example.clase7.dto.PersonajeRequestDTO;
import com.example.clase7.dto.PersonajeResponseDTO;
import com.example.clase7.repositories.PersonajeRepository;
import com.example.clase7.repositories.PersonajeRepositoryInterfaceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImple implements PersonajeService{
    @Autowired
    PersonajeRepositoryInterfaceImple personajeRepositoryImple;

    @Override
    public ArrayList<PersonajeResponseDTO> obtenerPersonajesPorNombre(PersonajeRequestDTO personaje){
        List<PersonajeRepository> personajes = personajeRepositoryImple.cargarBaseDeDatos();
        ArrayList<PersonajeResponseDTO> personajeResponseDTOS = new ArrayList<>();

        String nombreABuscar = personaje.getNombre();

        for (int i = 0; i < personajes.size(); i++) {
            String nombrePersonaje = personajes.get(i).getName();

            if(nombrePersonaje.contains(nombreABuscar)){
                PersonajeResponseDTO personajeEncontrado = new PersonajeResponseDTO();
                personajeEncontrado.setNombre(personajes.get(i).getName());
                personajeEncontrado.setAltura(personajes.get(i).getHeight());
                personajeEncontrado.setAnioNacimiento(personajes.get(i).getBirth_year());
                personajeEncontrado.setColorPelo(personajes.get(i).getHair_color());
                personajeEncontrado.setColorOjo(personajes.get(i).getEye_color());
                personajeEncontrado.setColorPiel(personajes.get(i).getSkin_color());
                personajeEncontrado.setEspecie(personajes.get(i).getSpecies());
                personajeEncontrado.setMasa(personajes.get(i).getMass());
                personajeEncontrado.setGenero(personajes.get(i).getGender());
                personajeEncontrado.setPlaneta(personajes.get(i).getHomeworld());

                personajeResponseDTOS.add(personajeEncontrado);
            }
        }

        return personajeResponseDTOS;
    }
}
