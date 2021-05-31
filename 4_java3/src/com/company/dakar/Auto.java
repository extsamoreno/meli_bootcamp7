package com.company.dakar;

public class Auto extends Vehiculo {
    public Auto(float velocidad, float aceleracion, float anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
        this.peso = 1000f;
        this.ruedas = 4;
    }
}

