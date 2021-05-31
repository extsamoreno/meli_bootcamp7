package com.company.ej2;

import java.util.Objects;

public abstract class Vehiculo {

    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Double.compare(vehiculo.getVelocidad(), getVelocidad()) == 0 && Double.compare(vehiculo.getAceleracion(), getAceleracion()) == 0 && Double.compare(vehiculo.getAnguloDeGiro(), getAnguloDeGiro()) == 0 && getPatente().equals(vehiculo.getPatente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVelocidad(), getAceleracion(), getAnguloDeGiro(), getPatente());
    }

    @Override
    public String toString() {
        return "Patente= " + patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}
