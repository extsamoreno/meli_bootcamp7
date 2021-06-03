package com.obtenerDiploma;

import com.models.Alumno;
import com.models.Diploma;

public class PromedioService {

    public static Diploma calcularPromedio (Alumno alumno){
        double[] promedio = {0};

        alumno.getAsignaturasAprobadas().stream().forEach(asignatura -> {
            promedio[0] += asignatura.getNota();
        });

        promedio[0] /= alumno.getAsignaturasAprobadas().size();
        String mensaje = (promedio[0] >= 9) ? "Felicitaciones!" : "Se graudo";

        return new Diploma(mensaje, promedio[0], alumno);
    }
}
