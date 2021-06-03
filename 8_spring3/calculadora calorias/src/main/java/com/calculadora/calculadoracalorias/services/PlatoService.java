package com.calculadora.calculadoracalorias.services;

import com.calculadora.calculadoracalorias.dto.IngredienteResponseDTO;
import com.calculadora.calculadoracalorias.dto.PlatoResponseDTO;
import com.calculadora.calculadoracalorias.dto.PlatoRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PlatoService {
     PlatoResponseDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO);
     ArrayList<IngredienteResponseDTO> caloriasCadaIngrediente(PlatoRequestDTO platoRequestDTO);
     IngredienteResponseDTO ingredienteConMasCalorias(PlatoRequestDTO platoRequestDTO);
}
