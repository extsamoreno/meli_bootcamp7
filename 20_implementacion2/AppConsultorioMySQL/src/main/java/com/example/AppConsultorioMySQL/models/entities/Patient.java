package com.example.AppConsultorioMySQL.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long dni;

    /*@OneToMany(mappedBy = "patient")
    private Set<Turn> turns;*/
}
