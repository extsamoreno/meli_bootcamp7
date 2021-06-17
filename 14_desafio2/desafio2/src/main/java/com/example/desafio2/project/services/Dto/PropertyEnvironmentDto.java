package com.example.desafio2.project.services.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyEnvironmentDto {
    private String environment_name;
    private double environment_size;
}
