package com.meli.AppConsultorioMySQL.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date init;
    private int duration;
    private String status;
    @ManyToOne
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private DentistEntity schedule;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private PatientEntity patient;
}
