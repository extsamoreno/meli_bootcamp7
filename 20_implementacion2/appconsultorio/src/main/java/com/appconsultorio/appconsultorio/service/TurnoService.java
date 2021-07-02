package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;
import com.appconsultorio.appconsultorio.repository.ITurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoService implements ITurnoService{

    ITurnoRepository iTurnoRepository;

    @Override
    public void crearTurno(Turno turno) {
        iTurnoRepository.save(turno);
    }

    @Override
    public List obtenerPacientesPorDia(Date dt) {
        return iTurnoRepository.findPacientesByDate(dt);
    }

    @Override
    public List<Odontologo> obtenerOdontologosDosTurnosPorFecha(Date dt) {
        return iTurnoRepository.findOdontologosDosTurnosPorFecha(dt);
    }

    @Override
    public List<Turno> obtenerTurnosFinalizados() {
        return iTurnoRepository.findTurnosLikeFinalizado();
    }

    @Override
    public List<Turno> obtenerTurnosPendientesPorFecha(Date dt) {
        return iTurnoRepository.findTurnosLikePendienteByDate(dt);
    }

    @Override
    public List<Turno> obtenerAgenda(int id) {
        return iTurnoRepository.findAgendaById(id);
    }

    @Override
    public List<Turno> obtenerTurnosReprogramados(int id) {
        return iTurnoRepository.findTurnosReprogramadosById(id);
    }


}
