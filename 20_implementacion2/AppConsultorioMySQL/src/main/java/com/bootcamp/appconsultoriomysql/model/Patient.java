package com.bootcamp.appconsultoriomysql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private Long id;

    @Column(name = "pat_dni")
    private String dni;

    @Column(name = "pat_name")
    private String name;

    @Column(name = "pat_lastname")
    private String lastname;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<Turn> turns;
}
