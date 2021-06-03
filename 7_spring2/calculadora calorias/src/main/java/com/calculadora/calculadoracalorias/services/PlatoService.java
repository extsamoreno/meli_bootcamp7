package com.calculadora.calculadoracalorias.services;

import com.calculadora.calculadoracalorias.services.dto.PlatoDTO;
import com.calculadora.calculadoracalorias.services.dto.PlatoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PlatoService {
     PlatoDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO);
}
