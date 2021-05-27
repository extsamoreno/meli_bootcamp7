package com.ejercicioMañana;
//Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir fracciones. Todos los métodos deben estar sobrecargados de modo que también puedan usarse para operar entre fracciones y números enteros (por ejemplo: ⅗+2 o ⅝*4).
public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion sumar(Fraccion fraccion){
        this.denominador = this.denominador * fraccion.denominador;
        this.numerador = this.numerador * fraccion.denominador + this.denominador * fraccion.numerador;
        return this;
    }

    public Fraccion sumar(int numeroEntero){

        return this;
    }
}
