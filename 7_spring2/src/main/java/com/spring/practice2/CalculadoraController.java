package com.spring.practice2;

import java.util.*;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calcular")
public class CalculadoraController {

    @PostMapping("/metrosCuadrados")
    public ResponseEntity<CasaDTO> calcularMetrosCuadrados (@RequestBody Casa casa) {
        CasaDTO casaDTO = new CasaDTO();
        double metrosTotales = Calculo.metrosCuadrados(casa);
        casaDTO.setMetrosCuadrados(metrosTotales);
        return new ResponseEntity<>(casaDTO, HttpStatus.OK);
    }

    @PostMapping("/valor")
    public ResponseEntity<Double> calcularValor (@RequestBody Casa casa) {
        double valor = 800;
        double precio = valor * Calculo.metrosCuadrados(casa);
        return new ResponseEntity<>(precio, HttpStatus.OK);
    }

    @PostMapping("/habitacionMasGrande")
    public ResponseEntity<HabitacionDTO> getHabitacionMasGrande (@RequestBody Casa casa) {
        HabitacionDTO habitacionDTO = Calculo.habitacionMasGrande(casa);
        return new ResponseEntity<>(habitacionDTO, HttpStatus.OK);
    }

    @PostMapping("/metrosHabitacion")
    public ResponseEntity<List<HabitacionDTO>> getMetrosHabitacion (@RequestBody Casa casa) {
        List<HabitacionDTO> habitaciones = new ArrayList<HabitacionDTO>();
        for (int i = 0; i < casa.getHabitaciones().size(); i++) {
            HabitacionDTO habitacion = new HabitacionDTO();
            habitacion.setNombre(casa.getHabitaciones().get(i).getNombre());
            habitacion.setMetrosCuadrados(casa.getHabitaciones().get(i).getAncho()*casa.getHabitaciones().get(i).getLargo());
            habitaciones.add(habitacion);
        }
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/edades/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        int edad = 0;
        LocalDate birthdate = LocalDate.of(anio, mes, dia);
        LocalDate now = LocalDate.now();

        edad = now.getYear() - birthdate.getYear();
        if(birthdate.getMonthValue() >= now.getMonthValue()){
            if(birthdate.getDayOfMonth() >= now.getDayOfMonth()){
                edad = edad -1;
            }
        }
        return new ResponseEntity<>(edad, HttpStatus.OK);
    }
}
