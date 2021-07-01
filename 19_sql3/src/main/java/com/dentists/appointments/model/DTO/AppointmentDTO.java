package com.dentists.appointments.model.DTO;

import com.dentists.appointments.model.Dentist;
import com.dentists.appointments.model.Patient;
import com.dentists.appointments.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private DentistDTO dentist;
    private Patient patient;
    private LocalDate date;
    private LocalTime time;
}
