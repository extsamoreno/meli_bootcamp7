package com.meli.AppConsultorioMySQL.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "appointments")
@NoArgsConstructor
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    private int duration;


    @ManyToOne
    @JoinColumn
    private SchedulesEntity schedule;


    @ManyToOne
    @JoinColumn
    private PacientEntity pacientEntity;

}
