package com.meli.tu_casita.controller;

import com.meli.tu_casita.model.dto.RealStateInDTO;
import com.meli.tu_casita.model.dto.RealStateOutDTO;
import com.meli.tu_casita.service.IRealStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/realState")
public class RealStateController {

    @Autowired
    IRealStateService realStateService;

    @GetMapping("/realStatelist")
    public ResponseEntity<List<RealStateOutDTO>> getRealStateList(){
        return new ResponseEntity<>(realStateService.getRealStateList(), HttpStatus.OK);
    }

    @PostMapping("/newRealState")
    public ResponseEntity<Void> addNewRealState(@RequestBody @Valid RealStateInDTO realStateInDTO){
        realStateService.addNewRealState(realStateInDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
