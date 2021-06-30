package com.meli.AppConsultorioMySQL.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "patients")
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;

    @OneToMany(mappedBy = "patient" )
    private Set<Apoointment> apoointment;

    public Patient(Long id, String dni, String name, String lastname, Set<Apoointment> apoointment) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.apoointment = apoointment;
    }
}
