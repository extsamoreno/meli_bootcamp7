package com.meli.consultorio.service;

import com.meli.consultorio.dto.PacienteDTO;
import com.meli.consultorio.model.Paciente;
import org.springframework.http.HttpStatus;

public interface IPacienteService {
    public HttpStatus agregarPaciente(PacienteDTO paciente);
    public HttpStatus modificarPaciente(Paciente paciente);
    public PacienteDTO consultarPaciente(int id);
    public HttpStatus eliminarPaciente(int id);
}
