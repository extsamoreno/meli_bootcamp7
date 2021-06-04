package com.example.clase7.services;

import com.example.clase7.dto.IngredienteResponseDTO;
import com.example.clase7.dto.PlatoProcesadoResponseDTO;
import com.example.clase7.dto.PlatoRequestDTO;
import com.example.clase7.dto.PlatoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PlatoService {
    PlatoResponseDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO);
    ArrayList<IngredienteResponseDTO> caloriasCadaIngrediente(PlatoRequestDTO platoRequestDTO);
    IngredienteResponseDTO ingredienteConMasCalorias(PlatoRequestDTO platoRequestDTO);
    ArrayList<PlatoProcesadoResponseDTO> platosProcesados(PlatoRequestDTO[] platos);
}
