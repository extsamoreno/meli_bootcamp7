package com.company.dakar;

public class Moto extends Vehiculo {
    public Moto(float velocidad, float aceleracion, float anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
        this.peso = 300f;
        this.ruedas = 2;
    }
}
