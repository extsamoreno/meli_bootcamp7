package com.meli.diploma;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @PostMapping("/obtener_diploma")
    public ResponseEntity<Map<String,Object>> enviarDiploma(@RequestBody Alumno alumno){
        Map<String, Object> map= new HashMap<>();
        String mensaje="";
        if(alumno.promedioNotas()>9)
            mensaje="Felicitaciones por tu excelente promedio! sigue asi";
        else
            mensaje="Otro anio que culmina";
        map.put("mensaje",mensaje);
        map.put("promedio",alumno.promedioNotas());
        map.put("alumno",alumno.getNombre());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
