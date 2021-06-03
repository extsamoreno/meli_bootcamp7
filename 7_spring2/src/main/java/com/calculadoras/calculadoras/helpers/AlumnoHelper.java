package com.calculadoras.calculadoras.helpers;
import com.calculadoras.calculadoras.entity.Asignatura;
import java.util.List;

public class AlumnoHelper {

    public static int getPromedio(List<Asignatura> asignaturas){
        int total=0;
        for (Asignatura asignatura: asignaturas
             ) {
            total += asignatura.getNota();
        }
       return total / asignaturas.size();
    }

    public static String getMensaje(int promedio){
        return promedio > 9 ? "Felicitaciones" : "";
    }


}
