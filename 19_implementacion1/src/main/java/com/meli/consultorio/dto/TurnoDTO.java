package com.meli.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {
    private int paciente;
    private int odontologo;
    private LocalDate fecha;
    private String horaInicio;
    private String horaFin;
    private int tipoServicio;
}
