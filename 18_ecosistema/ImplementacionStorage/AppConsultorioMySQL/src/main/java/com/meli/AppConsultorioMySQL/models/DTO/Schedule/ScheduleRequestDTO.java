package com.meli.AppConsultorioMySQL.models.DTO.Schedule;

import com.meli.AppConsultorioMySQL.models.Dentist;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ScheduleRequestDTO {

    private Date date_init;
    private Date date_finish;
    private Dentist dentist;
}
