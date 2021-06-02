package com.example.demo;

import lombok.*;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor

public class Habitacion {
    private String nombre;
    private double ancho;
    private double largo;

    public Habitacion(String nombre) {
        this.nombre = nombre;
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
