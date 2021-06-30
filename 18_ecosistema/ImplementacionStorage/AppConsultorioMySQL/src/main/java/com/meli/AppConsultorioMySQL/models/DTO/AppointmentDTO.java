package com.meli.AppConsultorioMySQL.models.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentDTO {

    private Date date;
    private int durations;
    // status 1 -> Pending, 2-> Finish 3-> Postponed 4->Cancel
    private int status;
}
