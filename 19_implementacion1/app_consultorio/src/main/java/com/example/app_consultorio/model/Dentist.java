package com.example.app_consultorio.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "den_id")
    private Long id;

    @Column(name = "den_name")
    private String name;

    @Column(name = "den_phone_number")
    private String phoneNumber;

    @Column(name = "den_start_time")
    private Time startTime;

    @Column(name = "den_end_time")
    private Time endTime;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;
}
