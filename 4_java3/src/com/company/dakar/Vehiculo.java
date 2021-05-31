package com.company.dakar;

public abstract class Vehiculo {
    private float velocidad;
    private float aceleracion;
    private float anguloGiro;
    private String patente;
    protected float peso;
    protected int ruedas;

    public String getPatente() {
        return patente;
    }

    public Vehiculo(float velocidad, float aceleracion,float anguloGiro,String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
    }

    public float calcularMaximaVelocidad() {
        //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        return (float) ((this.velocidad * (0.5) * this.aceleracion) / (this.anguloGiro * (this.peso - this.ruedas * 100)));
    }
}

