package com.dentists.appointments.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppReproRequests {

    @JsonProperty("patient_dni")
    private String patDni;

    private LocalDate date;
    private LocalTime time;

    @JsonProperty("new_date")
    private LocalDate newDate;
    @JsonProperty("new_time")
    private LocalTime newTime;

    @JsonProperty("dentist_name")
    private String dentName;

}
