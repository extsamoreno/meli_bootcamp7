package Dakar;

import java.util.List;

public class Vehiculo {
    protected float velocidad, aceleracion;
    protected int anguloDeGiro;

    public float getVelocidad() {
        return velocidad;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public int getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public String getPatente() {
        return patente;
    }

    protected String patente;
    protected int peso;
    protected int ruedas;

    public Vehiculo(float velocidad, float aceleracion, int anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }
}
