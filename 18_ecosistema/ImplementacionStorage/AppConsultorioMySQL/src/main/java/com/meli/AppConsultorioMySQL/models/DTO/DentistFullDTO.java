package com.meli.AppConsultorioMySQL.models.DTO;

import com.meli.AppConsultorioMySQL.models.DTO.Schedule.ScheduleDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DentistFullDTO {

    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private Set<ScheduleDTO> schedules;
}
