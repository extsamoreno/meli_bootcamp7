package com.example.ApiSpring2.controllers;

import com.example.ApiSpring2.Service.CasaService;
import com.example.ApiSpring2.entities.Habitacion;
import com.example.ApiSpring2.entities.HabitacionMetroCuadrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/casa")
public class CasaController {
    CasaService service = new CasaService();
    public CasaController(){
        service.cargarBase();
    }
    @GetMapping("/metros/{id}")
    public ResponseEntity<Integer> getMetros(@PathVariable("id") Integer id){
        return new ResponseEntity<Integer>(service.getMetrosTotales(service.getCasa(id).getHabitaciones()), HttpStatus.OK);
    }
    @GetMapping("/metros/precio/{id}")
    public ResponseEntity<Integer> getPrecio(@PathVariable("id") Integer id){
        return new ResponseEntity<Integer>(service.getPrecio(service.getCasa(id).getHabitaciones()), HttpStatus.OK);
    }
    @GetMapping("/habitacion/grande/{id}")
    public ResponseEntity<Habitacion> getHabitacionMasGrande(@PathVariable("id") Integer id){
        return new ResponseEntity<Habitacion>(service.getMaxHabitacion(service.getCasa(id).getHabitaciones()), HttpStatus.OK);
    }
    @GetMapping("/habitacion/cantidad/{id}")
    public ResponseEntity<ArrayList<HabitacionMetroCuadrado>> getCantidadPorHabitacion(@PathVariable("id") Integer id){
        return new ResponseEntity<ArrayList<HabitacionMetroCuadrado>>(service.getHabitacionMetroCuadrado(service.getCasa(id).getHabitaciones()), HttpStatus.OK);
    }

}
