package com.meli.AppConsultorioMySQL.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    private Long id;
    private Date init;
    private Date finish;
    private int dentistId;
}
