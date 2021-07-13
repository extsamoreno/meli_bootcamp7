package com.example.dentaloffice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private long id;

    @Column(name = "patient_name", nullable = false, length = 30)
    private String name;

    @Column(name = "patient_surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "patient_dni", nullable = false, length = 30)
    private String dni;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Turn> patient_turns;
}
