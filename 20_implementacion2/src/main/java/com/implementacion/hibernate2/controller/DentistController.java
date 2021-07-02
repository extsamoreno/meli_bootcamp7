package com.implementacion.hibernate2.controller;

import com.implementacion.hibernate2.controller.dto.dentists.DentistAndTurnsListDTO;
import com.implementacion.hibernate2.controller.dto.dentists.DentistDTO;
import com.implementacion.hibernate2.model.service.dentists.IDentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    //@Autowired
    private final IDentistService dentistService;

    public DentistController(IDentistService dentistService){
        this.dentistService = dentistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> listDentists(@PathVariable Long id){
        return new ResponseEntity<>(dentistService.getDentist(id), HttpStatus.OK);
    }


    // EJERCICIO 2
    // Listar todos los dentistas que tengan más de dos turnos en una fecha.
    // Listar todos los dentistas que tengan más o igual que N turnos en una fecha.
    @GetMapping("/turns-by-date")
    public ResponseEntity<DentistAndTurnsListDTO> listDentistsWithNTurnsByDate(@RequestParam String date, @RequestParam(defaultValue = "0") int turns){
        return new ResponseEntity<>(dentistService.listDentistByDateAndTurns(date, turns), HttpStatus.OK);
    }

}
