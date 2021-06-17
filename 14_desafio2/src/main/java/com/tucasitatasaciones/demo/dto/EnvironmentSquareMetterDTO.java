package com.tucasitatasaciones.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentSquareMetterDTO extends EnvironmentDTO{
    @JsonProperty("environment_square_metters")
    private double squareMetters;
}
