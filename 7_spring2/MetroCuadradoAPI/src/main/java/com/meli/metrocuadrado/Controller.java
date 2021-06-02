package com.meli.metrocuadrado;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
