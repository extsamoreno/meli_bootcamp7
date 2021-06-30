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
@Table(name = "dentists")
@NoArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Schedule> schedules;

    public Dentist(Long id, String dni, String name, String lastname, Set<Schedule> schedules) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.schedules = schedules;
    }
}
