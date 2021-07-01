package com.meli.consultorio.models.dtos;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long id;
    private Integer scheduleDay;
    private Time scheduleFrom;
    private Time scheduleTo;
    private Long dentistId;
}
