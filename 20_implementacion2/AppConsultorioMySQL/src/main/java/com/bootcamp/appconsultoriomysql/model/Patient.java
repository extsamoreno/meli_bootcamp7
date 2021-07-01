package com.bootcamp.appconsultoriomysql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "patients")
@Getter
@Setter
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

    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Set<Turn> turns;

}
