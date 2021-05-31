package com.company;

import java.util.Objects;

public class Vehiculo {

    private double velocidad;
    private double aceleración;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleración = aceleración;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleración() {
        return aceleración;
    }

    public void setAceleración(double aceleración) {
        this.aceleración = aceleración;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Double.compare(vehiculo.velocidad, velocidad) == 0 && Double.compare(vehiculo.aceleración, aceleración) == 0 && Double.compare(vehiculo.anguloDeGiro, anguloDeGiro) == 0 && Double.compare(vehiculo.peso, peso) == 0 && ruedas == vehiculo.ruedas && patente.equals(vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocidad, aceleración, anguloDeGiro, patente, peso, ruedas);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleración=" + aceleración +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
