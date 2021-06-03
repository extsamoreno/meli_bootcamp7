package primerejercicio.metrocuadrado.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primerejercicio.metrocuadrado.web.service.ServiceEdad;

@RestController
public class EdadController {

    @Autowired
    private ServiceEdad serviceEdad;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> getEdad(@PathVariable("dia") String dia, @PathVariable("mes") String mes, @PathVariable("anio") String anio){
        return new ResponseEntity<>(serviceEdad.calcularEdad(dia, mes, anio) , HttpStatus.OK);
    }
}
