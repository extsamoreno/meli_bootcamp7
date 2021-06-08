package com.example.demo.services;


import com.example.demo.dto.PlatoRequestDTO;
import com.example.demo.dto.PlatoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface PlatoService {
     PlatoResponseDTO caloriasTotalesPlato(PlatoRequestDTO platoRequestDTO);
}
