package com.calculadora.calculadoracalorias.services;

import com.calculadora.calculadoracalorias.services.dto.PlatoResponseDTO;
import com.calculadora.calculadoracalorias.services.dto.PlatoRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface PlatoService {
     PlatoResponseDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO);
}
