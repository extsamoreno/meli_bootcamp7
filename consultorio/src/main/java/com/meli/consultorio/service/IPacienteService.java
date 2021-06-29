package com.meli.consultorio.service;

import com.meli.consultorio.dto.response.PacienteResponse;
import com.meli.consultorio.model.Paciente;

import java.util.List;

public interface IPacienteService {
    public Paciente getPaciente(int id);
    public List<Paciente> findAllPacientes();
}
