package com.consultorio.AppConsultorioMySQL.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
}
