package com.meli.Muelitas.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentDTO {

    private Date date;
    // status 1 -> Pending, 2-> Finish 3-> Postponed 4->Cancel
    private int status;
}
