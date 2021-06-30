package com.example.practica_1_integration.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "professionals")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "enrollment")
    private String enrollment;

    @OneToMany(mappedBy = "professional")
    private Set<Appointment> appointment;
}
