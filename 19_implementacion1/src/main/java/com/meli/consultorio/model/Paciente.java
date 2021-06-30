package com.meli.consultorio.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "IdPaciente")
    private Set<Turno> turnos= new HashSet<>();
}
