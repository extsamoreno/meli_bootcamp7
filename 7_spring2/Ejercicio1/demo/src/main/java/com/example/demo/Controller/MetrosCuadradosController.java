package com.example.demo.Controller;

import com.example.demo.CalculoMetroCuadrado;
import com.example.demo.DTO.Casa;
import com.example.demo.DTO.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MetrosCuadradosController {



    @PostMapping("/calculoMetroCuadrado")
    public ResponseEntity<Respuesta> calcularMetroCuadrado(@RequestBody Casa casa){

        Respuesta respuesta = CalculoMetroCuadrado.calcularMetrosCuadradosCasa(casa);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/valorCasa")
    public ResponseEntity<Respuesta> calcularValorCasa(@RequestBody Casa casa){

        Respuesta respuesta = CalculoMetroCuadrado.calcularValorCasa(casa);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/habitacionMasGrande")
    public ResponseEntity<Respuesta> calcularHabitacionMasGrande(@RequestBody Casa casa){

        Respuesta respuesta = CalculoMetroCuadrado.habitacionMasGrande(casa);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/habitacionMetrosCuadrados")
    public ResponseEntity<Respuesta> calcularHabitacionMetrosCuadrados(@RequestBody Casa casa){

        Respuesta respuesta = CalculoMetroCuadrado.metroCuadradoCadaHabitacion(casa);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/calculoTodo")
    public ResponseEntity<Respuesta> calcularTodo(@RequestBody Casa casa){

        Respuesta respuesta = CalculoMetroCuadrado.calcularCasa(casa);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
