package com.meli.tucasita.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyWithBiggerEnvDTO {
    private String name;
    private EnvironmentResponseDTO environment;
}
