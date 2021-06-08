package ej3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
public class Alumno {
    private String nombre;
    private List<Asignatura> aprobadas;

    public DiplomaDTO generarDiploma() {
        float promedio = 0;
        if (aprobadas.size() > 0) {
            for (Asignatura asigantura : aprobadas) {
                promedio += asigantura.getNota();
            }
        }
        promedio = promedio/aprobadas.size();
        String mensaje = promedio>=9?"Felicitacions":"Mediocre";
        return new DiplomaDTO(mensaje,nombre, promedio);
    }
}
