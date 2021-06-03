package com.example.demo.controller;

import com.example.demo.demo.Casa;
import com.example.demo.demo.CasaDTO;
import com.example.demo.demo.Habitacion;
import com.example.demo.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/metrosCuadrados")
public class CasaController {
    @Autowired
    private CasaService serviceCasa;

    @PostMapping("/save")
    public ResponseEntity<Casa> save(@RequestBody Casa casa){
        return new ResponseEntity<>(serviceCasa.guardarCasa(casa), HttpStatus.CREATED);
    }

    @GetMapping("/metros/{casa}")
    public ResponseEntity<CasaDTO> getMetrosCuadrados(@PathVariable ("casa") String nombre){
        return new ResponseEntity<>(serviceCasa.devolverCasa(nombre), HttpStatus.OK);
    }

    @GetMapping("/precio/{casa}")
    public ResponseEntity<CasaDTO> getPrecio(@PathVariable ("casa") String nombre){
        return new ResponseEntity<>(serviceCasa.getPrecio(nombre), HttpStatus.OK);
    }

    @GetMapping("/casaHabitacionMasGrande")
    public ResponseEntity<Casa> getCasaHabitacionMasGrande(){
        return new ResponseEntity<>(serviceCasa.obtenerCasaHabitacionGrande(),HttpStatus.OK);
    }

    @GetMapping("/metrosHabitacion/{casa}")
    public ResponseEntity<HashMap<Double, Habitacion>> getMetrosPorHabitacion(Casa casa){
        return new ResponseEntity<>(serviceCasa.obtenerListaHabitacionesMetros(casa), HttpStatus.OK);
    }

}
