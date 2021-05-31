package com.company.ej2;

public class Auto extends Vehiculo {

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPatente(patente);
        this.setPeso(1000);
        this.setRuedas(4);
    }

}
