package com.example.app_consultorio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private Long id;

    @Column(name = "pat_name")
    private String name;

    @Column(name = "pat_dni")
    private String dni;

    @Column(name = "pat_address")
    private String address;

    @Column(name = "pat_social_work")
    private String social_work;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;
}
