package com.meli.AppConsultorioMySQL.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistScheduleDto {

    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private List<ScheduleDto> schedules;
}
