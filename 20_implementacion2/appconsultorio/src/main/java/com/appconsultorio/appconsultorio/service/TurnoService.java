package com.appconsultorio.appconsultorio.service;
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
}
