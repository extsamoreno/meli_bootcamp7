package com.ejercicioMañana;
//Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir fracciones. Todos los métodos deben estar sobrecargados de modo que también puedan usarse para operar entre fracciones y números enteros (por ejemplo: ⅗+2 o ⅝*4).
public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion sumar(Fraccion fraccion){
        this.denominador = this.denominador * fraccion.denominador;
        this.numerador = this.numerador * fraccion.denominador + this.denominador * fraccion.numerador;
        return this;
    }

    public Fraccion sumar(int numeroEntero){
        return this.sumar(new Fraccion(numeroEntero, 1));
    }

    public Fraccion restar(Fraccion fraccion){
        this.denominador = this.denominador * fraccion.denominador;
        this.numerador = this.numerador * fraccion.denominador - this.denominador * fraccion.numerador;
        return this;
    }

    public Fraccion restar(int numeroEntero){
        return this.restar(new Fraccion(numeroEntero, 1));
    }

    public Fraccion multiplicar(Fraccion fraccion){
        this.denominador = this.denominador * fraccion.denominador;
        this.numerador = this.numerador * fraccion.numerador;
        return this;
    }

    public Fraccion multiplicar(int numeroEntero){
        return this.multiplicar(new Fraccion(numeroEntero, 1));
    }

    public Fraccion dividir(Fraccion fraccion){
        this.denominador = this.denominador * fraccion.numerador;
        this.numerador = this.numerador * fraccion.denominador;
        return this;
    }

    public Fraccion dividir(int numeroEntero){
        return this.dividir(new Fraccion(numeroEntero, 1));
    }

    @Override
    public String toString() {
        return "Fraccion{" + numerador +"/" + denominador +'}';
    }
}
