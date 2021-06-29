package com.example.muelitas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "turnos")
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.EAGER)
    private Profesional profesional;
    @ManyToOne(fetch=FetchType.EAGER)
    private Paciente paciente;
    private LocalDateTime fecha;
    private LocalDateTime fechaBaja;
}
