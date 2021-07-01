package com.meli.consultorio.models.dtos;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long id;
    private Integer scheduleDay;
    private LocalTime scheduleFrom;
    private LocalTime scheduleTo;
    private Long dentistId;
}
