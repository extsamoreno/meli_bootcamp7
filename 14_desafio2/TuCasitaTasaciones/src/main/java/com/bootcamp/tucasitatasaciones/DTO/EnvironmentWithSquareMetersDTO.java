package com.bootcamp.tucasitatasaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentWithSquareMetersDTO {
    private String name;
    private Double squareMeters;
}
