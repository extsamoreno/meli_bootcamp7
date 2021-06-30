package com.meli.consultorio.controller;


import com.meli.consultorio.dto.PacienteDTO;
import com.meli.consultorio.model.Paciente;
import com.meli.consultorio.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping("/agregar")
    public ResponseEntity<HttpStatus> agregarPaciente(@RequestBody PacienteDTO paciente){
        HttpStatus status=pacienteService.agregarPaciente(paciente);
        return new ResponseEntity<>(status, status);
    }

    @PostMapping("/modificar")
    public ResponseEntity<HttpStatus> modificarPaciente(@RequestBody Paciente paciente){
        HttpStatus status= pacienteService.modificarPaciente(paciente);
        return new ResponseEntity<>(status, status);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<PacienteDTO> consultarPaciente(@PathVariable int id){
        return new ResponseEntity<>(pacienteService.consultarPaciente(id), HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<HttpStatus> eliminarPaciente(@PathVariable int id){
        return new ResponseEntity<>(pacienteService.eliminarPaciente(id), HttpStatus.OK);
    }
}
