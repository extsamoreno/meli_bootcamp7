package com.meli.spring_day_2.Controllers;

import com.meli.spring_day_2.Clases.Casa;
import com.meli.spring_day_2.Dto.CasaDto;
import com.meli.spring_day_2.Services.CalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    CalculadoraService cs = new CalculadoraService();

    @PostMapping("/mts")
    public ResponseEntity<CasaDto> calcularMts2(@RequestBody Casa casa){
        CasaDto result = cs.calcularMts(casa);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
