package com.example.challenge2.dtos;


import com.example.challenge2.models.Environment;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BiggerEnvironmentResponseDTO {
    private String name;
    private Environment biggerEnvironment;
}
