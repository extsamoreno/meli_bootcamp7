package com.appconsultorio.appconsultorio.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private int dni;

    @Column(name = "obra_social")
    private String obra_social;

}
