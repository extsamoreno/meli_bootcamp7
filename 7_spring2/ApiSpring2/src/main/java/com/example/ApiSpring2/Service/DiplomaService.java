package com.example.ApiSpring2.Service;

import com.example.ApiSpring2.Repositories.AlumnosNotasRepository;
import com.example.ApiSpring2.dtos.AlumnoDTO;
import com.example.ApiSpring2.dtos.AsignaturaDTO;
import com.example.ApiSpring2.dtos.DiplomaDTO;
import com.example.ApiSpring2.entities.Alumno;

import java.util.ArrayList;

public class DiplomaService {
    ArrayList<Alumno> alumnos = AlumnosNotasRepository.cargarNotas();
    public DiplomaDTO getDiploma(Integer id){
        Alumno alumno = null;
        for(Alumno al : alumnos){
            if(al.getId() == id) {
                alumno = al;
                break;
            }
        }
        if(alumno!=null) {
            float promedio = 0;
            int contador = 1;
            for (AsignaturaDTO asignatura : alumno.getAsignaturas()) {
                if (asignatura.getNota() > 6) {
                    promedio += asignatura.getNota();
                    contador++;
                }
            }
            promedio = (float) (promedio / (contador - 1));
            String mensaje = promedio > 8 ? "felicidades" : "";
            return new DiplomaDTO(mensaje, promedio, new AlumnoDTO(alumno.getNombre(),alumno.getAsignaturas()));
        }
        else{
            return null;
        }
    }
    public ArrayList<Alumno> getAlumnos(){
        return AlumnosNotasRepository.cargarNotas();
    }
}
