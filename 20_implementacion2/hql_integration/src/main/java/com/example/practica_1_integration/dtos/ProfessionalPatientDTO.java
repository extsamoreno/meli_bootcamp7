package com.example.practica_1_integration.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessionalPatientDTO {
    private String professionalName;
    private String professionalSurname;
    private String patientName;
    private String patientSurname;
}
