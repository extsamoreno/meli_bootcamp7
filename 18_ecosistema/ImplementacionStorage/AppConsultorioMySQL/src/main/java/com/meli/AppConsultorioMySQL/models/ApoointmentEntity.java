package com.meli.AppConsultorioMySQL.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "apoointments")
@NoArgsConstructor
public class ApoointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    private int durations;

    @OneToMany(mappedBy = "patient")
    private Set<PatientEntity> patientEntitySet;

    @OneToMany(mappedBy = "shedule")
    private Set<ScheduleEntity> scheduleEntitySet;


}
