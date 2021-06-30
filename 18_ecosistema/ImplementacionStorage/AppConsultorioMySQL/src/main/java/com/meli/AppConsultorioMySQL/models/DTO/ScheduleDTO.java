package com.meli.AppConsultorioMySQL.models.DTO;

import com.meli.AppConsultorioMySQL.models.Apoointment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ScheduleDTO {
    private Date date_init;
    private Date date_finish;
    private Set<AppointmentDTO> apoointment;
}
