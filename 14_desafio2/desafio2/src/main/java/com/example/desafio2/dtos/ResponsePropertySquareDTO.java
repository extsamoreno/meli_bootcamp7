package com.example.desafio2.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePropertySquareDTO {
    private String propertyName;
    private double totalSquareMeters;
}
