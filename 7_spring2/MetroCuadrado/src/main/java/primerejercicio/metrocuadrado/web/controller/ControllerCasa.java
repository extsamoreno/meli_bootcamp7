package primerejercicio.metrocuadrado.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primerejercicio.metrocuadrado.web.DTO.Casa;
import primerejercicio.metrocuadrado.web.DTO.Habitacion;
import primerejercicio.metrocuadrado.web.DTO.ResponseDTOcasa;
import primerejercicio.metrocuadrado.web.service.ServiceCasa;

import java.util.HashMap;

@RestController
@RequestMapping("/metrosCuadrados")
public class ControllerCasa {
    @Autowired
    private  ServiceCasa serviceCasa;

    @PostMapping("/save")
    public ResponseEntity<Casa> save(@RequestBody Casa casa){
        return new ResponseEntity<>(serviceCasa.guardarCasa(casa), HttpStatus.CREATED);
    }

    @GetMapping("/metros/{casa}")
    public ResponseEntity<ResponseDTOcasa> getMetrosCuadrados(@PathVariable ("casa") String nombre){
        return new ResponseEntity<>(serviceCasa.devolverCasa(nombre), HttpStatus.OK);
    }

    @GetMapping("/precio/{casa}")
    public ResponseEntity<ResponseDTOcasa> getPrecio(@PathVariable ("casa") String nombre){
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
