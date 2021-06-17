package com.example.desafio2.dtos;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSquareMetersEnvironmentDTO {
    private String propertyName;
    private List<ResponseEnvironmentDTO> environments;
}