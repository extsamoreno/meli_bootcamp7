package com.meli.metrocuadrado;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearCasa(@RequestBody Casa casa){
        Map<String, Object> map = new HashMap<>();
        casa.setMetrosTotales(casa.metrosCuadradosTotales());
        map.put("m2_totales",casa.getMetrosTotales());
        map.put("precio_total",casa.valorCasa());
        map.put("habitacion_mas_grande",casa.habitacionMasGrande());
        map.put("m2_por_habitacion",casa.habitacionesConMetros());
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        Fecha fecha= new Fecha(dia,mes,anio);
        return new ResponseEntity<>(fecha.calcularEdad(),HttpStatus.OK);
    }

}
