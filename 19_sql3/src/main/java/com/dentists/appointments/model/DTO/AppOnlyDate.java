package com.dentists.appointments.model.DTO;
import com.dentists.appointments.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppOnlyDate {
    private LocalDate date;
    private LocalTime time;
    private Status status;
}
