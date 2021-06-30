package com.example.practica_1_integration.dtos;

import com.example.practica_1_integration.models.Patient;
import com.example.practica_1_integration.models.Professional;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestDTO {
    private Professional professional;
    private Patient patient;
}
