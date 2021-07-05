package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.TurnDTO;
import com.appconsultorio.appconsultorio.model.Turn;
import com.appconsultorio.appconsultorio.service.ITurnService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turn")
@AllArgsConstructor
public class TurnController {

    ITurnService iTurnService;
/*
    @PostMapping("/reprogram")
    public String createReprogramedTurn(@RequestBody TurnDTO turnDTO) throws Exception {
        iTurnService.createReprogramedTurn(turnDTO);
        return "Turno reprogramado correctamente";
    }
*/
    @PostMapping("/create")
    public String loadTurn(@RequestBody TurnDTO turnDTO) throws Exception {
        iTurnService.createTurn(turnDTO);
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
