package com.meli.muelitas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class AppointmentInDTO {

    @NotNull(message = "PatientId must not be empty")
    private Long patientId;

    @NotNull(message = "DentistId must not be empty")
    private Long dentistId;

    @NotNull(message = "appointmentDate must not be empty")
    private LocalDate appointmentDate;

    @NotNull(message = "appointmentTime must not be empty")
    private LocalTime appointmentTime;

}
