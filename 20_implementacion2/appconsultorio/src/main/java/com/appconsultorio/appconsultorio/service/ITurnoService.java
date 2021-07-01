package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ITurnoService {
    public void crearTurno(Turno turno);
    public List obtenerPacientesPorDia(Date dt);
    public List<Odontologo> obtenerOdontologosDosTurnosPorFecha(Date dt);
    public List<Turno> obtenerTurnosFinalizados();
    public List<Turno> obtenerTurnosPendientesPorFecha(Date dt);
}
