package com.meli.consultorio.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_paciente", referencedColumnName = "ID")
    private Paciente IdPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_odontologo", referencedColumnName = "ID")
    private Odontologo IdOdontologo;

    private LocalDate fecha;
    private String horaInicio;
    private String horaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_servicio", referencedColumnName = "ID")
    private Servicio tipoServicio;
}
