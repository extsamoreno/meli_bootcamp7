package com.tucasitaTasaciones.service;

import com.tucasitaTasaciones.dto.CalculateResponseDTO;
import com.tucasitaTasaciones.dto.EnvironmentDTO;

public interface ICalculateService {
    CalculateResponseDTO calculateSquareMeters(Integer id);

    CalculateResponseDTO calculateValue(Integer id);

    CalculateResponseDTO calculateLargestRoom(Integer id);

    CalculateResponseDTO calculateEnvironments(Integer id);

}
