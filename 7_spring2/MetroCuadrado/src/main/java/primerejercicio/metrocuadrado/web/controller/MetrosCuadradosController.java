package primerejercicio.metrocuadrado.web.controller;

import org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primerejercicio.metrocuadrado.web.DTO.Casa;
import primerejercicio.metrocuadrado.web.DTO.Habitacion;
import primerejercicio.metrocuadrado.web.DTO.ResponseDTOcasa;
import primerejercicio.metrocuadrado.web.service.CasaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/metrosCuadrados")
public class MetrosCuadradosController {

    CasaService casaService = new CasaService();

    @PostMapping("/save")
    public ResponseEntity<Casa> save(@RequestBody Casa casa){
        return new ResponseEntity<>(casaService.guardarCasa(casa), HttpStatus.CREATED);
    }

    @GetMapping("/metros/{casa}")
    public ResponseEntity<ResponseDTOcasa> getMetrosCuadrados(@PathVariable ("casa") String nombre){
        return new ResponseEntity<>(casaService.devolverCasa(nombre), HttpStatus.OK);
    }

    @GetMapping("/precio/{casa}")
    public ResponseEntity<ResponseDTOcasa> getPrecio(@PathVariable ("casa") String nombre){
        return new ResponseEntity<>(casaService.getPrecio(nombre), HttpStatus.OK);
    }

    @GetMapping("/casaHabitacionMasGrande")
    public ResponseEntity<Casa> getCasaHabitacionMasGrande(){
        return new ResponseEntity<>(casaService.obtenerCasaHabitacionGrande(),HttpStatus.OK);
    }

    @GetMapping("/metrosHabitacion")
    public ResponseEntity<HashMap<Double, Habitacion>> getMetrosPorHabitacion(Casa casa){
        return new ResponseEntity<>(casaService.obtenerListaHabitacionesMetros(casa), HttpStatus.OK);
    }

}
