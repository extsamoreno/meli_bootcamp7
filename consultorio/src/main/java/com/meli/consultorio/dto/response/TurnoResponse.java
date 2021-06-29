package com.meli.consultorio.dto.response;

import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.model.Profesional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TurnoResponse {
    private int tur_id;
    private Date tur_fecha;
    private Profesional profesional;
    private Paciente paciente;
}
