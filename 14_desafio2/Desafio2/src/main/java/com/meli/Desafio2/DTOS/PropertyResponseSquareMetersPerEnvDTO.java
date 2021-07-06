package com.meli.desafio2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyResponseSquareMetersPerEnvDTO {
    private List<EnvironmentSquareMetersDTO> environmentSquareMeters;
}
