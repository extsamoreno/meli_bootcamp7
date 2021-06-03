package com.spring.practice2;

public class Habitacion {
    private String nombre;
    private double ancho, largo;

    public Habitacion(String nombre, double ancho, double largo) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }
}
