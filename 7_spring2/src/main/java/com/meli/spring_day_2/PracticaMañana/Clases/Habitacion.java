package com.meli.spring_day_2.PracticaMañana.Clases;

public class Habitacion {
    private String nombre;
    private float ancho;
    private float largo;

    public Habitacion() {
    }

    public Habitacion(String nombre, int ancho, int largo) {
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

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }
}
