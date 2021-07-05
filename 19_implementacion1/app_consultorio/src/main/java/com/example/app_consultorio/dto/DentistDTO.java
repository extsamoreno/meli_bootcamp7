package com.example.app_consultorio.dto;

import lombok.Data;

import javax.persistence.Column;
import java.sql.Time;

@Data
public class DentistDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private Time startTime;
    private Time endTime;
}
