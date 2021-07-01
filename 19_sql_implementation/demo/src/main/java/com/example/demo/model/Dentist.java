package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dentist_id")
    private Long id;

    @Column(name = "dentist_name")
    private String name;

    @OneToMany(mappedBy = "dentist")
    private Set<Schedule> scheduleSet;

    @OneToMany(mappedBy = "dentist")
    private Set<Appointment> appointments;
}