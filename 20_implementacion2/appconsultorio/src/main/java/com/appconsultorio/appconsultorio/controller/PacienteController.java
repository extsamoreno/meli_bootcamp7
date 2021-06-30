package com.appconsultorio.appconsultorio.controller;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.service.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paciente")
@AllArgsConstructor
public class PacienteController {

    IPacienteService iPacienteService;

    @PostMapping("/crearpaciente")
    public String crearPaciente(@RequestBody Paciente paciente){
        iPacienteService.crearPaciente(paciente);
        return "Paciente creado correctamente";
    }


}
