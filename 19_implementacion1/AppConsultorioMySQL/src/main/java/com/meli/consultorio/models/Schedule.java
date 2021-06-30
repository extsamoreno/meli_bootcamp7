package com.meli.consultorio.models;

import lombok.*;
import javax.persistence.*;
import java.sql.Time;

@Getter @Setter
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long id;

    private String schedule_day;
    private Time schedule_from;
    private Time schedule_to;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

}
