package com.company.Ejercicio2;

public class Motos extends Vehiculo{

    public Motos(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }

    public Motos() {
        this.setRuedas(2);
        this.setPeso(300);
    }
}
