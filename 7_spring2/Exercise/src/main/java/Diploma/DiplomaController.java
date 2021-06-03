package Diploma;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {
    @PostMapping("/promedio")
    public String getPromedio(@RequestBody Alumno alumno) {
        DiplomaCore diplomaCore = new DiplomaCore();
        return diplomaCore.calcularPromedio(alumno);
    }
}
