package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private Integer id;

    @Column(name = "pat_name")
    private String name;

    @Column(name = "pat_dni")
    private String dni;

    @Column(name = "pat_address")
    private String adress;

    @Column(name = "pat_socialWork")
    private String socialWork;

    @OneToMany(mappedBy = "id")
    private Set<Appointment> appointments;

    @OneToMany(mappedBy = "id")
    private Set<Dentist> dentists;




}
