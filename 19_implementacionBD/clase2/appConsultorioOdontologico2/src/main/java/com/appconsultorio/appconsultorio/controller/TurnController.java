package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Patient;
import com.appconsultorio.appconsultorio.model.Turn;
import com.appconsultorio.appconsultorio.service.DentistService;
import com.appconsultorio.appconsultorio.service.IPatientService;
import com.appconsultorio.appconsultorio.service.ITurnService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turn")
@AllArgsConstructor
public class TurnController {

    ITurnService iTurnService;

    @PostMapping("/create")
    public String loadTurn(@RequestBody Turn turn){
        iTurnService.createTurn(turn);
        return "Turno creado correctamente";
    }

    @PostMapping("/edit")
    public String editTurn(@RequestBody Turn turn){
        iTurnService.updateTurn(turn);
        return "Turno editado correctamente";
    }

    @PostMapping("/remove")
    public String removeTurn(@RequestParam int id){
        iTurnService.removeTurn(id);
        return "Turno eliminado correctamente";
    }

    @GetMapping("/getall")
    public List<Turn> getTurns(){
        return iTurnService.getTurn();
    }
}
