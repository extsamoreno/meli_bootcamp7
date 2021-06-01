package com.company;

public abstract class Vehiculo {
    private float velocidad, accelaracion, angulo_giro, peso;
    private String patente;
    private byte ruedas;

    public Vehiculo(float velocidad, float accelaracion, float angulo_giro, float peso, String patente, byte ruedas) {
        this.velocidad = velocidad;
        this.accelaracion = accelaracion;
        this.angulo_giro = angulo_giro;
        this.peso = peso;
        this.patente = patente;
        this.ruedas = ruedas;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getAccelaracion() {
        return accelaracion;
    }

    public void setAccelaracion(float accelaracion) {
        this.accelaracion = accelaracion;
    }

    public float getAngulo_giro() {
        return angulo_giro;
    }

    public void setAngulo_giro(float angulo_giro) {
        this.angulo_giro = angulo_giro;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public byte getRuedas() {
        return ruedas;
    }

    public void setRuedas(byte ruedas) {
        this.ruedas = ruedas;
    }
}
