package com.example.dentaloffice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentist_id")
    private long id;

    @Column(name = "dentist_name", nullable = false, length = 30)
    private String name;

    @Column(name = "dentist_surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "dentist_dni", nullable = false, length = 30)
    private String dni;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Turn> dentist_turns;
}
