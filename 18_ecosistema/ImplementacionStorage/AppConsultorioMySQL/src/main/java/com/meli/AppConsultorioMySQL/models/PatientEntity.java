package com.meli.AppConsultorioMySQL.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    @ManyToOne()
    @JoinColumn(name="appointment_id", referencedColumnName = "id")
    private ApoointmentEntity apoointmentEntity;


    public PatientEntity(Long id, String dni, String name, String lastname, ApoointmentEntity apoointmentEntity) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.apoointmentEntity = apoointmentEntity;
    }
}
