package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Turno;
import com.appconsultorio.appconsultorio.repository.ITurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TurnoService implements ITurnoService{

    ITurnoRepository iTurnoRepository;

    @Override
    public void crearTurno(Turno turno) {
        iTurnoRepository.save(turno);
    }

}
