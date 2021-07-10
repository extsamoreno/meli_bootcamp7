package com.appconsultorio.appconsultorio.controller;

import com.appconsultorio.appconsultorio.dtos.request.TurnDTO;
import com.appconsultorio.appconsultorio.model.Dentist;
import com.appconsultorio.appconsultorio.model.Turn;
import com.appconsultorio.appconsultorio.service.ITurnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turn")
@AllArgsConstructor
public class TurnController {

    ITurnService iTurnService;


    /**
     * @return turnos reprogramados
     */
    @GetMapping("/findreprogramedturns")
    public ResponseEntity<List<Turn>> findTurnosLikeReprogramed(){
        return new ResponseEntity<>(iTurnService.findTurnosLikeReprogramed(), HttpStatus.OK);
    }

    /**
     * @return turnos finalizados
     */
    @GetMapping("/findfinalizedturns")
    public ResponseEntity<List<Turn>> findTurnosLikeFinalizado(){
        return new ResponseEntity<>(iTurnService.findTurnosLikeFinalizado(), HttpStatus.OK);
    }

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
