package spring2.demo.models;

import java.util.List;

public class Diploma {
    String mensaje;
    double promedio;
    String alumno;

    public Diploma(Alumno alumno) {
        this.promedio = promedio(alumno.getAsignaturas());
        this.alumno = alumno.nombre;

        if (promedio > 9){
            this.mensaje = "Felicidades, su promedio superó 9!!!!";
        } else {
            this.mensaje = "Felicidades por recibirse";
        }
    }

    private double promedio(List<Asignatura> lAsignatura){
        double total = lAsignatura.stream()
                .mapToInt(Asignatura::getNota)
                .sum();
        return total/lAsignatura.size();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
}
