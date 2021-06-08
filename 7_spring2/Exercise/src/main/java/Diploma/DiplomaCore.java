package Diploma;

public class DiplomaCore {
    public String calcularPromedio(Alumno alumno) {
        int cont = 0;
        float promedio = 0.0f;
        for (Asignaturas obj : alumno.getAsignaturas()) {
            promedio += obj.getNota();
            cont++;
        }
        promedio = promedio / cont;
        if (promedio > 9)
            return "Felicitaciones " + alumno.getNombre() + " su promedio fue de " + promedio;
        else
            return alumno.getNombre() + " su promedio fue de " + promedio;
    }
}
