package com.example.CalculadoraMetrosCuadrados;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    @PostMapping("/metrosCuadrados")
    public ResponseEntity<CasaDTO> calcularMetrosCuadrados(@RequestBody Casa casa){
        double metrosCuadrados = 0;
        CasaDTO casaMetrosCuadrdos = new CasaDTO();

        for (int i = 0; i < casa.getHabitaciones().size(); i++) {
            metrosCuadrados = metrosCuadrados + (casa.getHabitaciones().get(i).getAncho() * casa.getHabitaciones().get(i).getLargo());
        }

        casaMetrosCuadrdos.setMetrosCuadrados(metrosCuadrados);

        return new ResponseEntity<>(casaMetrosCuadrdos, HttpStatus.OK);
    }

    @PostMapping("/metrosCuadrados/valorCasa")
    public ResponseEntity<Double> calcularValorCasa(@RequestBody Casa casa){
        double metrosCuadrados = 0;
        double valorCasa = 0;

        for (int i = 0; i < casa.getHabitaciones().size(); i++) {
            metrosCuadrados = metrosCuadrados + (casa.getHabitaciones().get(i).getAncho() * casa.getHabitaciones().get(i).getLargo());
        }

        valorCasa = metrosCuadrados * 800;

        return new ResponseEntity<>(valorCasa, HttpStatus.OK);
    }

    @PostMapping("/metrosCuadrados/habitacionMasGrande")
    public ResponseEntity<HabitacionDTO> devolverHabitacionMasGrande(@RequestBody Casa casa){
        double metrosCuadrados = 0;
        double metrosCuadradosHabitacionMasGrande = 0;
        HabitacionDTO habitacionMasGrande = new HabitacionDTO();

        for (int i = 0; i < casa.getHabitaciones().size(); i++) {
            metrosCuadrados = casa.getHabitaciones().get(i).getAncho() * casa.getHabitaciones().get(i).getLargo();

            if(metrosCuadrados > metrosCuadradosHabitacionMasGrande){
                metrosCuadradosHabitacionMasGrande = metrosCuadrados;
                habitacionMasGrande.setNombre(casa.getHabitaciones().get(i).getNombre());
                habitacionMasGrande.setMetrosCuadrados(metrosCuadradosHabitacionMasGrande);
            }

            metrosCuadrados = 0;
        }

        return new ResponseEntity<>(habitacionMasGrande, HttpStatus.OK);
    }

    @PostMapping("/metrosCuadrados/porHabitacion")
    public ResponseEntity<List<HabitacionDTO>> devolverMetrosCuadradosPorHabitacion(@RequestBody Casa casa){
        List<HabitacionDTO> habitaciones = new ArrayList<HabitacionDTO>();
        double metrosCuadrados = 0;

        for (int i = 0; i < casa.getHabitaciones().size(); i++) {
            HabitacionDTO habitacion = new HabitacionDTO();

            metrosCuadrados = casa.getHabitaciones().get(i).getAncho() * casa.getHabitaciones().get(i).getLargo();

            habitacion.setMetrosCuadrados(metrosCuadrados);
            habitacion.setNombre(casa.getHabitaciones().get(i).getNombre());

            habitaciones.add(habitacion);
        }

        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/edades/calcular/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        int edad = 0;

        LocalDate birthdate = LocalDate.of(anio, mes, dia);
        LocalDate now = LocalDate.now();

        edad = now.getYear() - birthdate.getYear();

        if(birthdate.getMonthValue() > now.getMonthValue()){
            if(birthdate.getDayOfMonth() > now.getDayOfMonth()){
                edad = edad -1;
            }
        }

        return new ResponseEntity<>(edad, HttpStatus.OK);
    }
}
