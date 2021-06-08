package calculadoraYStarWars.calculadoraYStarWars.service;

import calculadoraYStarWars.calculadoraYStarWars.dto.IngredienteResponseDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PlatoProcesadoResponseDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PlatoRequestDTO;
import calculadoraYStarWars.calculadoraYStarWars.dto.PlatoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PlatoService {
    PlatoResponseDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO);
    ArrayList<IngredienteResponseDTO> caloriasCadaIngrediente(PlatoRequestDTO platoRequestDTO);
    IngredienteResponseDTO ingredienteConMasCalorias(PlatoRequestDTO platoRequestDTO);
    ArrayList<PlatoProcesadoResponseDTO> platosProcesados(PlatoRequestDTO[] platos);
}
