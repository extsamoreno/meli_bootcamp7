package com.appconsultorio.appconsultorio.controller;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;
import com.appconsultorio.appconsultorio.service.IPacienteService;
import com.appconsultorio.appconsultorio.service.ITurnoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("turno")
@AllArgsConstructor
public class TurnoController {

    ITurnoService iTurnoService;

    @PostMapping("/crearturno")
    public String crearTurno(@RequestBody Turno turno){
        iTurnoService.crearTurno(turno);
        return "Turno creado correctamente";
    }

    @PostMapping ("/obtenerpacientespordia")
    public List obtenerPacientesPorDia(@RequestParam String date){
        LocalDateTime dt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return iTurnoService.obtenerPacientesPorDia(dt);
    }

}
