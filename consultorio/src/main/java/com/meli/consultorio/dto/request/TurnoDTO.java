package com.meli.consultorio.dto.request;

import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.model.Profesional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TurnoDTO {

    private Date tur_fecha;
    private Profesional profesional;
    private Paciente paciente;
}
