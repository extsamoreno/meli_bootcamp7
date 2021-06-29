package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long id;

    @Column(name = "patient_name")
    private String name;

    @OneToOne(mappedBy = "patient")
    private Appointment appointment;
}