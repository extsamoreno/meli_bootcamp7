package com.example.muelitas.dto;

import com.example.muelitas.domain.Doctor;
import com.example.muelitas.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AppointmentDTO {
    private String id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String status;
}
