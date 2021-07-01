package com.example.demo.services.dtos;

import com.example.demo.model.Appointment;
import com.example.demo.model.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {

    private Long id;

    private String name;

    private Set<Schedule> scheduleSet;

    private Set<Appointment> appointments;
}
