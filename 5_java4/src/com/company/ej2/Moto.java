package com.company.ej2;

public class Moto extends Vehiculo {

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPatente(patente);
        this.setPeso(300);
        this.setRuedas(2);
    }

}
