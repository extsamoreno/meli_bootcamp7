package com.dentists.appointments.model.DTO;

import com.dentists.appointments.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AppDTOByDate {
    private String dentist_name;
    private String patients_name;
    private LocalDate date;
    private LocalTime time;
    private Status status;
}
