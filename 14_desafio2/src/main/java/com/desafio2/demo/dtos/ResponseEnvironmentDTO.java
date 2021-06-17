package com.desafio2.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEnvironmentDTO {
    private String environmentName;
    private double totalSquareMeters;
}
