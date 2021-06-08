package calculadoraYStarWars.calculadoraYStarWars.service;

import calculadoraYStarWars.calculadoraYStarWars.dto.PersonajeRequestDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PersonajeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public interface PersonajeService {
    ArrayList<PersonajeResponseDTO> obtenerPersonajesPorNombre(PersonajeRequestDTO personaje);
}
