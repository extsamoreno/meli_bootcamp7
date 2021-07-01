package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;

import java.time.LocalDateTime;
import java.util.List;

public interface ITurnoService {
    public void crearTurno(Turno turno);
    public List obtenerPacientesPorDia(LocalDateTime dt);
    public List<Odontologo> obtenerOdontologosDosTurnosPorFecha(LocalDateTime dt);
    public List<Turno> obtenerTurnosFinalizados();
}
