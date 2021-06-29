package com.meli.consultorio.controller;

import com.meli.consultorio.dto.request.PacienteDTO;
import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.repository.PacienteRepository;
import com.meli.consultorio.service.IPacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorio")

public class PacienteController {
    IPacienteService ipacienteService;
    PacienteRepository pacienteRepository;
    @GetMapping("/paciente/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("id") int id){
        return new ResponseEntity<>(ipacienteService.getPaciente(id),HttpStatus.OK);
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> getPacientes(){
        return new ResponseEntity<>(ipacienteService.findAllPacientes(),HttpStatus.OK);
    }
    @PostMapping("/crear")
    public String crearPaciente(@RequestBody Paciente paciente){
        pacienteRepository.save(paciente);
        return "Paciente guardado";
    }
}
