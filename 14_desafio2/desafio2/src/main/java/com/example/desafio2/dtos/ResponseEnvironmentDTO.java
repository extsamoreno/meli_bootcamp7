package com.example.desafio2.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEnvironmentDTO {
    private String environmentName;
    private double totalSquareMeters;
}
