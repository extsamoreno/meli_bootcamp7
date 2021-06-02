package com.example.demo.EjercicioCalculadoraEdad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
@RequestMapping("/calculadoraedad")
public class CalculadoraEdadController {

    @GetMapping("/edades/calcular/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        int edad = 0;

        LocalDate birthdate = LocalDate.of(anio, mes, dia);
        LocalDate now = LocalDate.now();

        edad = now.getYear() - birthdate.getYear();

        if(birthdate.getMonthValue() > now.getMonthValue() && birthdate.getDayOfMonth() > now.getDayOfMonth()){
                edad--;
        }else if(birthdate.getMonthValue() >= now.getMonthValue() && birthdate.getDayOfMonth() >= now.getDayOfMonth()){
                edad++;
        }

        return new ResponseEntity<>(edad, HttpStatus.OK);
    }

}
