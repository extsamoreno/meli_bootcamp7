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
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String tipoServicio;

    @OneToMany(mappedBy = "tipoServicio")
    private Set<Turno> turnos= new HashSet<>();
}
