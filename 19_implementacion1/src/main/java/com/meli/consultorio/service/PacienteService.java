package com.meli.consultorio.service;

import com.meli.consultorio.dto.PacienteDTO;
import com.meli.consultorio.dto.util.Mapper;
import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository iPacienteRepository;

    @Override
    public HttpStatus agregarPaciente(PacienteDTO paciente) {
        iPacienteRepository.save(Mapper.toPaciente(paciente));
        return HttpStatus.CREATED;
    }

    @Override
    public HttpStatus modificarPaciente(Paciente paciente) {
        iPacienteRepository.save(paciente);
        return HttpStatus.OK;
    }

    @Override
    public PacienteDTO consultarPaciente(int id) {
        return Mapper.toPacienteDTO(iPacienteRepository.getById(id));
    }

    @Override
    public HttpStatus eliminarPaciente(int id) {
        iPacienteRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }
}
