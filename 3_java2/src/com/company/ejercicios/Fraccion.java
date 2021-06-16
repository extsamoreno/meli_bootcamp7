package com.company.ejercicios;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador){
        this.denominador = denominador;
        this.numerador = numerador;
    }

    public Fraccion(){

    }

    public void sumar(Fraccion fraccion) {
        this.numerador = this.numerador + fraccion.getNumerador();
        this.denominador = this.denominador + fraccion.getDenominador();
    }

    public void restar(Fraccion fraccion) {
        this.numerador = this.numerador - fraccion.getNumerador();
        this.denominador = this.denominador - fraccion.getDenominador();
    }

    public void multiplicar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.getNumerador();
        this.denominador = this.denominador * fraccion.getDenominador();
    }

    public void division(Fraccion fraccion) {
        this.numerador = this.numerador / fraccion.getNumerador();
        this.denominador = this.denominador / fraccion.getDenominador();
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
