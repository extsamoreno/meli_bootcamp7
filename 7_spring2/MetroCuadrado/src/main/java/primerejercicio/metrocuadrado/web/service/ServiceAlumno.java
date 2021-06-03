package primerejercicio.metrocuadrado.web.service;

import org.springframework.stereotype.Service;
import primerejercicio.metrocuadrado.web.DTO.Alumno;
import primerejercicio.metrocuadrado.web.DTO.DiplomaDTO;

import java.awt.*;
import java.util.ArrayList;

@Service
public class ServiceAlumno {
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public Alumno guardarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
        return alumno;
    }

    public DiplomaDTO obtenerDiploma() {
        Alumno alumno = listaAlumnos.get(0);
        DiplomaDTO diploma = new DiplomaDTO();
        double promedio = calcularPromedio(alumno);

        diploma.setAlumno(alumno);
        diploma.setPromedio(promedio);

        if(promedio > 9)
            diploma.setMensaje("¡Felicidades!");

        return diploma;
    }

    private double calcularPromedio(Alumno alumno) {
        double notas =0.0;

        for(int i=0 ; i<alumno.getAsignaturas().size() ; i++){
            notas += alumno.getAsignaturas().get(i).getNota();
        }
        return notas/alumno.getAsignaturas().size();
    }
}
