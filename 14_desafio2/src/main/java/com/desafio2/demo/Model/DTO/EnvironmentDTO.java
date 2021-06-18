package com.desafio2.demo.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {
    private String name;
    @JsonProperty("Total square meters")
    private double totalMeter;
}
