package com.example.CalculadoraMetrosCuadrados;

public abstract class DiplomaDTO {
    private double promedio;
    private String nombreAlumno;

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }


    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
}
