package com.dentists.appointments.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "Appointmets")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "den_id")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "pat_id")
    private Patient patient;

    @Column(name = "startTime")
    private LocalTime startTime;
}
