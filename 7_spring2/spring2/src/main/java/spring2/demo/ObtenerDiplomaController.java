package spring2.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring2.demo.models.Alumno;
import spring2.demo.models.Diploma;

//Se necesita desarrollar un API que recibe un alumno que contiene su “nombre”, y todas las asignaturas aprobadas con “nombre” y “nota”, se requiere que se calcule el promedio de las notas obtenidas durante la carrera y genere el diploma con un “mensaje”, “promedio” y “alumno”.
//En caso que el promedio del alumno supere 9 deberá ser reconocido con una felicitación.

@RestController
@RequestMapping("/alumno")
public class ObtenerDiplomaController {
    @PostMapping
    public ResponseEntity<Diploma> getDiplomaByAlumno(@RequestBody Alumno alumno){
        return new ResponseEntity<>(new Diploma(alumno), HttpStatus.OK);
    }
}
