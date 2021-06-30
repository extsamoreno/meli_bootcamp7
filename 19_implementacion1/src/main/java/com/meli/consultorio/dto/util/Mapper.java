package com.meli.consultorio.dto.util;

import com.meli.consultorio.dto.PacienteDTO;
import com.meli.consultorio.dto.TurnoDTO;
import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.model.Turno;

public class Mapper {

    public static Paciente toPaciente(PacienteDTO paciente){
        Paciente pacienteRespuesta= new Paciente();
        pacienteRespuesta.setNombre(paciente.getNombre());
        pacienteRespuesta.setApellido(paciente.getApellido());
        return pacienteRespuesta;
    }

    public static PacienteDTO toPacienteDTO(Paciente paciente){
        PacienteDTO pacienteRespuesta= new PacienteDTO();
        pacienteRespuesta.setNombre(paciente.getNombre());
        pacienteRespuesta.setApellido(paciente.getApellido());
        return pacienteRespuesta;
    }

    public static Turno toTurno(TurnoDTO turno){
        Turno turnoRespuesta= new Turno();
        turnoRespuesta.setFecha(turno.getFecha());
        turnoRespuesta.setHoraFin(turno.getHoraFin());
        turnoRespuesta.setHoraInicio(turno.getHoraInicio());
        return turnoRespuesta;
    }
}
