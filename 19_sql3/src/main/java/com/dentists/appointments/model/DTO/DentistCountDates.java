package com.dentists.appointments.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDate;


public interface DentistCountDates {
     String getName();
     LocalDate getDate();
     @JsonProperty("Number dates")
     Long getNumberDates();
}
