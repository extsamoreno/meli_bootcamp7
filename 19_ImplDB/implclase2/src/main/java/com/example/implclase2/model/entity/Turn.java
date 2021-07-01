package com.example.implclase2.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "Turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turn_id")
    private long id;

    @Column(name = "turn_datetime", nullable = false)
    private Date datetime;

    @ManyToOne
    @JoinColumn(name = "fk_patient_id", referencedColumnName = "patient_id", nullable = false)
    private Patient patient;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "fk_dentist_id", referencedColumnName = "dentist_id", nullable = false)
    //private long dentist;
    private Dentist dentist;
}