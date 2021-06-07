package com.starwars.starwars.Services;


import com.starwars.starwars.Dto.PersonajeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public interface PersonajeService {

    public ArrayList<PersonajeResponseDTO> buscarPersonajes( String name);

}
