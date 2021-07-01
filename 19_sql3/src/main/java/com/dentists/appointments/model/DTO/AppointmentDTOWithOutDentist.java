package com.dentists.appointments.model.DTO;

import com.dentists.appointments.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTOWithOutDentist {
    private Patient patient;
    private LocalDate date;
    private LocalTime time;
}
