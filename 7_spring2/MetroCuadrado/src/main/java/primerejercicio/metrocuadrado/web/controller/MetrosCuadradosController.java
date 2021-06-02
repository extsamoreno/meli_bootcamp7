package primerejercicio.metrocuadrado.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primerejercicio.metrocuadrado.Casa;
import primerejercicio.metrocuadrado.Habitacion;
import primerejercicio.metrocuadrado.web.service.CasaService;

import java.util.ArrayList;

@RestController
@RequestMapping("/metrosCuadrados")
public class MetrosCuadradosController {

    ArrayList<Casa> listaCasas = new ArrayList<>();

    @PostMapping("/save")
    public ResponseEntity<Casa> save(@RequestBody Casa casa){
        listaCasas.add(casa);
        return new ResponseEntity<>(casa, HttpStatus.CREATED);
    }

    @GetMapping("/metros/{casa}")
    public double getMetrosCuadrados(@PathVariable ("casa") String nombre){
        CasaService casaService = new CasaService();
        return casaService.metrosCuadrados(devolverCasa(nombre));
    }

    //eso no se hace xd
    public Casa devolverCasa(String nombre){
        for(int i=0 ; i<listaCasas.size() ; i++){
            if(listaCasas.get(i).getNombre() == nombre){
             return listaCasas.get(i);
            }
        }
        return null;
    }

}
