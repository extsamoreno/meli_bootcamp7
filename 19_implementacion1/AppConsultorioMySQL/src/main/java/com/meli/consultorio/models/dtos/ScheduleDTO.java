package com.meli.consultorio.models.dtos;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long id;
    private String schedule_day;
    private Time schedule_from;
    private Time schedule_to;
    private Long dentist_id;
}
