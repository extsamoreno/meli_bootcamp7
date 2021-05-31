package com.company;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        this.setPeso(300);
        this.setRuedas(2);
    }
}
