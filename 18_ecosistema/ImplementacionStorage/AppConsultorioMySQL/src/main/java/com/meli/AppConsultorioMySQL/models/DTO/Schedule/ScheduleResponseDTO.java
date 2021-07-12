package com.meli.AppConsultorioMySQL.models.DTO.Schedule;

import com.meli.AppConsultorioMySQL.models.DTO.AppointmentDTO;
import com.meli.AppConsultorioMySQL.models.Dentist;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class ScheduleResponseDTO {
    private Long id;
    private Date date_init;
    private Date date_finish;
    private Dentist dentist;
    private Set<AppointmentDTO> apoointment;
}
