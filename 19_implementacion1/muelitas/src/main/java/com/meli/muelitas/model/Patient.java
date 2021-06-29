package com.meli.muelitas.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @Column(name = "id_patient")
    private long idPatient;
    private String name;
    private long dni;
    private long phone;

    @OneToMany(mappedBy = "patient")
    private Set<Turn> turns;


}
