package com.tucasitaTasaciones.service;

import com.tucasitaTasaciones.dto.ResponseDTO.CalculateResponseDTO;

public interface ICalculateService {

    CalculateResponseDTO calculateSquareMeters(Integer id);

    CalculateResponseDTO calculateValue(Integer id);

    CalculateResponseDTO calculateLargestRoom(Integer id);

    CalculateResponseDTO calculateEnvironmentsSquareMeters(Integer id);

}
