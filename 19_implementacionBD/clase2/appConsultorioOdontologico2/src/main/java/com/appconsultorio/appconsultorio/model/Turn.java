package com.appconsultorio.appconsultorio.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "Turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "startTime")
    private Time time;

    @Column(name = "isActive")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @ManyToMany
    @JoinTable(
            name = "schedule",
            joinColumns = @JoinColumn(name = "id_turn"),
            inverseJoinColumns = @JoinColumn(name = "id_dentist")
    )
    Set<Dentist> dentistset;
/*
    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private Dentist profesional;
*/
}
