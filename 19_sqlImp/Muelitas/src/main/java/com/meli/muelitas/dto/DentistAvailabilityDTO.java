package com.meli.muelitas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;

@Data
public class DentistAvailabilityDTO {

    private Long dentistId;

    private String dayOfWeek;

    private LocalTime dayStart;

    private LocalTime DayEnd;

    private LocalTime breakStart;

    private LocalTime breakEnd;

}
