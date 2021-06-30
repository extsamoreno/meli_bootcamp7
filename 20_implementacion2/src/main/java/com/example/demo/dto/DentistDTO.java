package com.example.demo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class DentistDTO {

    private Long id;

    private String name;

    private Long enrollment;

    private Set<ScheduleDTO> schedules;

}
