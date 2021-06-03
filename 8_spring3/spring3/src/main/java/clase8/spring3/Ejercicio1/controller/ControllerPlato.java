package clase8.spring3.Ejercicio1.controller;

import clase8.spring3.Ejercicio1.dominio.Plato;
import clase8.spring3.Ejercicio1.service.ICaloriasService;
import clase8.spring3.Ejercicio1.service.dto.PlatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora-calorias")
public class ControllerPlato {

    @Autowired
    ICaloriasService caloriasService;

    @PostMapping("/plato")
    public ResponseEntity<PlatoDTO> plato(@RequestBody Plato plato){
        return new ResponseEntity<>(caloriasService.getPlato(plato), HttpStatus.OK);
    }

}
