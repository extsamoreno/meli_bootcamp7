package com.meli.consultory.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long dni;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "patient")
    private Set<Turn> turns;
}
