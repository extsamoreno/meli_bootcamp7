package com.company;

public class Fraccion {
    int denominador;
    int numerador;

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public Fraccion(){

    }
    public Fraccion(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void sumar(Fraccion fraccion){
        this.numerador = this.numerador + fraccion.getNumerador();
    }

    public void sumar(int numero){
        this.numerador = this.numerador + (numero * this.numerador);
    }

    public String multiplicar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.getNumerador();
        this.denominador = this.denominador * fraccion.getDenominador();
        return toString();
    }

    public String multiplicar(int numero){
        this.numerador = this.numerador * numero;
        return toString();
    }
    public String dividir(Fraccion fraccion){
        this.numerador = this.numerador * fraccion.getDenominador();
        this.denominador = this.denominador * fraccion.getNumerador();
        return toString();
    }
    public String dividir(int numero){
        this.numerador = this.numerador * numero;
        return toString();
    }
    public void restar(Fraccion fraccion){
        this.numerador = this.numerador - fraccion.getNumerador();
    }

    public void restar(int numero){
        this.numerador = this.numerador - numero;
    }


    @Override
    public String toString(){
        return this.numerador + "/" + this.denominador;
    }
}
