package boorcamp.spring.dos.demo.services;

import boorcamp.spring.dos.demo.entidades.Asignatura;
import boorcamp.spring.dos.demo.entidades.Diploma;
import boorcamp.spring.dos.demo.entidades.Estudiante;
import org.springframework.stereotype.Service;

@Service
public class DiplomaServices {

    public Diploma getDiploma(Estudiante estudiante){
        double promedio= 0;
        for (Asignatura as:estudiante.getAsignaturas()) {
            promedio += as.getNota();
        }
        promedio = promedio/estudiante.getAsignaturas().size();
        Diploma result= new Diploma(estudiante.getNombre(),promedio>9,promedio);
        return result;
    }

}
