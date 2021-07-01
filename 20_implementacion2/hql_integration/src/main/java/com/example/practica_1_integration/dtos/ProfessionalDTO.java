package com.example.practica_1_integration.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessionalDTO {
    private Long id;
    private String name;
    private String surname;
    private String enrollment;
}
