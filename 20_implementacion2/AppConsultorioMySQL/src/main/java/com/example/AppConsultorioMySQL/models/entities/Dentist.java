package com.example.AppConsultorioMySQL.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long enrollment;

    @OneToMany(mappedBy = "dentist")
    private Set<Schedule> schedules;
}