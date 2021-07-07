package com.meli.muelitas.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AppointmentDTO {

    private Long id;

    private PatientDTO patientDTO;

    private DentistDTO dentistDTO;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private String status;

    private AppointmentDTO appointmentCancelled;

}
