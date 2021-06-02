package com.calculadora;

import com.models.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @PostMapping("/m2")
    public ResponseEntity<ResponseCasaDTO> calcularMetrosCuadrados(@RequestBody() Casa casa){
       return (new ResponseEntity<>(HouseService.calcularMetrosTotales(casa), HttpStatus.OK));
    }

    @PostMapping("/calcularValor")
    public ResponseEntity<ResponseCasaDTO> calcularValor (@RequestBody() Casa casa) {
        return (new ResponseEntity<>(HouseService.calcularValor(casa), HttpStatus.OK));
    }

    @PostMapping("/habitacionMasGrande")
    public ResponseEntity<Habitacion> habitacionMasGrande (@RequestBody() Casa casa){
        return (new ResponseEntity<>(HouseService.habitacionMasGrande(casa), HttpStatus.OK));
    }

    @PostMapping("/m2Habitacion")
    public ResponseEntity<ResponseHabitacionDTO> calcularM2Habitacion(@RequestBody() Casa casa){
        return (new ResponseEntity<>(HouseService.calcularM2Habitacion(casa), HttpStatus.OK));
    }

    @GetMapping("/calcularEdad/{day}/{month}/{year}")
    public ResponseEntity<ResponseEdadDTO> calcularEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        return (new ResponseEntity<>(AgeService.calcularEdad( day, month,year), HttpStatus.OK));
    }

}
