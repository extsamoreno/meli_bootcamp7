package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.model.Odontologo;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.repository.IOdontologoRepository;
import com.appconsultorio.appconsultorio.repository.IPacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PacienteService implements IPacienteService{

    IPacienteRepository iPacienteRepository;

    @Override
    public void crearPaciente(Paciente paciente) {
        iPacienteRepository.save(paciente);
    }
}
