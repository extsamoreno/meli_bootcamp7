package ej2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {

        return new ResponseEntity<>(EdadCore.getEdad(dia, mes, ano), HttpStatus.OK);
    }
}
