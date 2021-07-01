package com.example.practica_1_integration.dtos;

import com.example.practica_1_integration.models.Patient;
import com.example.practica_1_integration.models.Professional;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private Professional professional;
    private Patient patient;
    private LocalDateTime date;
    private String state;
}
