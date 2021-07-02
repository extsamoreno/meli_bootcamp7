package com.meli.AppConsultorioMySQL.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    private Date init;
    private int duration;
    private String status;
    private String patientName;
    private String patientLastName;
    private String dentistName;
    private String dentistLastName;
}
