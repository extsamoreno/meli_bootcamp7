package com.dentists.appointments.model.DTO;

import com.dentists.appointments.model.Patient;
import com.dentists.appointments.model.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTOWithOutDentist {
    private PatientDTO patient;
    private LocalDate date;
    private LocalTime time;
    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("New appointment")
    private AppOnlyDate reProgram;
}
