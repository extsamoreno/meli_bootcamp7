package com.meli.spring_day_2.PracticaMañana.Controllers;

import com.meli.spring_day_2.PracticaMañana.Clases.Casa;
import com.meli.spring_day_2.PracticaMañana.Dto.CasaDto;
import com.meli.spring_day_2.PracticaMañana.Services.CalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    CalculadoraService cs = new CalculadoraService();

    @PostMapping("/mts")
    public ResponseEntity<CasaDto> calcularMts2(@RequestBody Casa casa){
        CasaDto result = cs.calcularMts(casa);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/edad/{dia}/{mes}/{año}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año){
        return new ResponseEntity<>(cs.calcularEdad(dia,mes,año), HttpStatus.OK);
    }
}
