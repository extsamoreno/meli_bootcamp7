package com.example.demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

@RestController
@RequestMapping("/api")

public class CasaControlador {
    @PostMapping("/casa")
    public ResponseEntity<CasaRespuesta> getDatosCasa(@RequestBody Casa casa){
        //Casa casa1 = new Casa();
        //casa1 = casa;
        CasaRespuesta casaResp = new CasaRespuesta();


        casaResp.setMetrosCuadradosTotales(getMetrosCuadrados(casa));
        casaResp.setValorCasa(800*getMetrosCuadrados(casa));

        casaResp.setHabGrande(getHabitacionGrande(casa));
        casaResp.setHm(getMetrosCuadPorHab(casa));

        return new ResponseEntity(casaResp, HttpStatus.OK);

    }

    HashMap<String, Double> getMetrosCuadPorHab(Casa casa){
        double metros = 0;
        HashMap<String, Double> mPorHab = new HashMap<String, Double>();
        for(Habitacion hab : casa.getHabitaciones()){
            metros = getMetrosCuadradosHab(hab);
            mPorHab.put(hab.getNombre(), metros);
        }
        return mPorHab;
    }

    private double getMetrosCuadrados(Casa casa){
        double metros = 0;

        for(Habitacion hab : casa.getHabitaciones()){
            System.out.println("Ancho "+hab.getAncho() + "Largo" +hab.getLargo());
            metros += getMetrosCuadradosHab(hab);
        }

        System.out.println("Los metros son: " +casa.getHabitaciones());
        return metros;
    }

    private Habitacion getHabitacionGrande(Casa casa){
        Habitacion habGrande = new Habitacion();
        double metrosMax = 0;
        for (Habitacion hab : casa.getHabitaciones()) {
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

    //EJ2

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public ResponseEntity<String> getEdad (@PathVariable String dia, @PathVariable String mes, @PathVariable String anio){

        DateTimeFormatter fmt = null;

        if(anio.length() == 4) {fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");}
        else if (anio.length() == 2) {fmt = DateTimeFormatter.ofPattern("dd/MM/yy");}
        else {return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);}

        LocalDate fechaNac = LocalDate.parse(dia + '/' + mes + '/' + anio, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s años", periodo.getYears());

        return new ResponseEntity<String>(String.valueOf(periodo.getYears()), HttpStatus.OK);
    }


    //EJ3
    @PostMapping("/alumno")
    public ResponseEntity<DiplomaDTO> getDiploma(@RequestBody Alumno alumno){
        DiplomaDTO diploma = new DiplomaDTO();
        float promedio = calcularPromedio(alumno);

        diploma.setAlumno(alumno.getNombre());
        diploma.setPromedio(promedio);
        diploma.setMensaje("toma tu diploma");

        if(promedio >= 9){
            diploma.setMensaje("Felicitaciones Capo");
        }

        return new ResponseEntity(diploma, HttpStatus.OK);
    }


    private float calcularPromedio(Alumno alumno){
       float promedio =0;
       int tamanio =  alumno.getAsignaturas().size();
        System.out.println("El tamanio de calcular grupo es: "+tamanio);
       for(Asignatura a: alumno.getAsignaturas()) {
           promedio += a.getNota();
           System.out.println("El promedio es: "+promedio);
       }
       return (promedio / tamanio);
    }
}
