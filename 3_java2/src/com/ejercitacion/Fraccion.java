package com.ejercitacion;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion() {
    }

    public void sumar(Fraccion fraccion) {
        this.numerador = (this.numerador * fraccion.getDenominador()) + (fraccion.getNumerador() * this.denominador);
        this.denominador *= fraccion.getDenominador();
    }

    public void sumar(int numero) {
        this.numerador += numero * this.denominador;
    }

    public void restar(Fraccion fraccion) {
        this.numerador = (this.numerador * fraccion.getDenominador()) - (fraccion.getNumerador() * this.denominador);
        this.denominador *= fraccion.getDenominador();
    }

    public void restar(int numero) {
       this.numerador -= numero * this.denominador;
    }

    public void multiplicar(Fraccion fraccion) {
        this.numerador *= fraccion.getNumerador();
        this.denominador *= fraccion.getDenominador();
    }

    public void multiplicar(int numero) {
        this.numerador *= numero;
    }

    public void dividir(Fraccion fraccion) {
        this.numerador *= fraccion.getDenominador();
        this.denominador *= fraccion.getNumerador();
    }

    public void dividir(int numero) {
        this.denominador *= numero;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
