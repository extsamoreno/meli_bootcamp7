package com.appconsultorio.appconsultorio.controller;
import com.appconsultorio.appconsultorio.model.Paciente;
import com.appconsultorio.appconsultorio.model.Turno;
import com.appconsultorio.appconsultorio.service.IPacienteService;
import com.appconsultorio.appconsultorio.service.ITurnoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
