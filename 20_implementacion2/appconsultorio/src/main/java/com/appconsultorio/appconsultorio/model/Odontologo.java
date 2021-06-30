package com.appconsultorio.appconsultorio.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "odontologos")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odontologo")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "especialidad")
    private String especialidad;
}
