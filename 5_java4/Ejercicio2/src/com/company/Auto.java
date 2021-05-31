package com.company;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        this.setPeso(1000);
        this.setRuedas(4);
    }
}
