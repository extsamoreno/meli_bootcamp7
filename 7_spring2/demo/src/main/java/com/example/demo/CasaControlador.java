package com.example.demo;

import org.apache.coyote.Response;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

@RestController
@RequestMapping("/Calculador")
public class CasaControlador {

    @PostMapping("/Casa")
    public ResponseEntity<CasaRespuesta> procesarDatosCasa(@RequestBody Casa casa){
        CasaRespuesta objRespuesta = new CasaRespuesta();

        objRespuesta.setMetrosCuadTotales(getMetrosCuadrados(casa));
        objRespuesta.setPrecio(objRespuesta.getMetrosCuadTotales() * 800);
        objRespuesta.setHabGrande(getHabitacionGrande(casa));

        cargarMetrosCuadradosHab(casa,objRespuesta);

        return new ResponseEntity(objRespuesta, HttpStatus.OK);
    }

    private double getMetrosCuadrados(Casa casa){
        double metrosCuadTotal = 0;
        for (Habitacion hab : casa.getListHabitaciones()) {
            metrosCuadTotal += getMetrosCuadradosHab(hab);
        }
        return metrosCuadTotal;
    }

    private Habitacion getHabitacionGrande(Casa casa){
        Habitacion habGrande = new Habitacion();
        double metrosMax = 0;
        for (Habitacion hab : casa.getListHabitaciones()) {
            if(getMetrosCuadradosHab(hab) > metrosMax){
                habGrande = hab;
                metrosMax = getMetrosCuadradosHab(hab);
            }
        }
        return habGrande;
    }

    private double getMetrosCuadradosHab(Habitacion hab){
        return hab.getAncho() * hab.getLargo();
    }

    private void cargarMetrosCuadradosHab(Casa casa, CasaRespuesta casaResp){
        for (Habitacion hab : casa.getListHabitaciones()) {
            casaResp.getHm().put(hab.getNombre(),getMetrosCuadradosHab(hab));
        }
    }

    //EJERCICIO 2
    @GetMapping("/Edad/{dia}/{mes}/{anio}")
    public ResponseEntity<String> getEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio){
        int edad = Period.between(LocalDate.parse(anio + "-" + mes + "-" + dia), LocalDate.now()).getYears();

        return new ResponseEntity<>(String.valueOf(edad), HttpStatus.OK);
    }
}
