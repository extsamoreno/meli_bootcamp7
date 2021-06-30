package com.example.demo.entity;

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

    @Column(name = "pat_name")
    private String name;

    @Column(name = "pat_dni")
    private long dni;

    @OneToMany(mappedBy = "patient")
    private Set<Turn> turns;
}