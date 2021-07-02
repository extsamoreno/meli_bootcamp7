package com.meli.AppConsultorioMySQL.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;

//    @OneToMany(mappedBy = "patient")
//    private Set<AppointmentEntity> appointments;

    public PatientEntity(String dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }
}
