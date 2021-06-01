package com.meli.act2;

public class Moto extends Vehiculo{

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        this.peso= 300;
        this.rueda= 2;
        this.aceleracion= aceleracion;
        this.velocidad= velocidad;
        this.anguloDeGiro=anguloDeGiro;
        this.patente= patente;
    }
}
