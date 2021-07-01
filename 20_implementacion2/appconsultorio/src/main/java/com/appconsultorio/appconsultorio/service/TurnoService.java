package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;
import com.appconsultorio.appconsultorio.repository.ITurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List obtenerPacientesPorDia(LocalDateTime dt) {
        return iTurnoRepository.findPacientesByDate(dt);
    }

    @Override
    public List<Odontologo> obtenerOdontologosDosTurnosPorFecha(LocalDateTime dt) {
        return iTurnoRepository.findOdontologosDosTurnosPorFecha(dt);
    }

    @Override
    public List<Turno> obtenerTurnosFinalizados() {
        return iTurnoRepository.findTurnosLikeFinalizado();
    }

    @Override
    public List<Turno> obtenerTurnosPendientesPorFecha(LocalDateTime dt) {
        return iTurnoRepository.findTurnosLikePendienteByDate(dt);
    }


}
