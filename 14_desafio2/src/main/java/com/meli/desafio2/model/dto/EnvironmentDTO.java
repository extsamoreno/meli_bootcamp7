package com.meli.desafio2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {
    private String environment_name;
    private double environment_mts2;
}
