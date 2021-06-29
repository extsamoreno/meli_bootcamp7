package com.meli.consultorio.service;

import com.meli.consultorio.dto.request.PacienteDTO;
import com.meli.consultorio.dto.response.PacienteResponse;
import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Paciente getPaciente(int id){
        Optional<Paciente> item = pacienteRepository.findById(id);
        return item.orElse(null);
    }
    @Override
    public List<Paciente> findAllPacientes(){
        return pacienteRepository.findAll();
    }

    public void createPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }
}
