package com.company.ej4;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion sumar(Fraccion fraccion) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * fraccion.denominador;
        retorno.numerador = ( retorno.denominador / this.denominador * this.numerador ) +
                ( retorno.denominador / fraccion.denominador * fraccion.numerador );

        return retorno;

    }

    public Fraccion sumar(int nro) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador;
        retorno.numerador = ( retorno.denominador / this.denominador * this.numerador ) +
                ( retorno.denominador * nro );

        return retorno;

    }

    public Fraccion restar(Fraccion fraccion) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * fraccion.denominador;
        retorno.numerador = ( retorno.denominador / this.denominador * this.numerador ) -
                ( retorno.denominador / fraccion.denominador * fraccion.numerador );

        return retorno;

    }

    public Fraccion restar(int nro) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador;
        retorno.numerador = ( retorno.denominador / this.denominador * this.numerador ) -
                ( retorno.denominador * nro );

        return retorno;

    }

    public Fraccion multiplicar(Fraccion fraccion) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * fraccion.denominador;
        retorno.numerador = this.numerador * fraccion.numerador;

        return retorno;

    }

    public Fraccion multiplicar(int nro) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador;
        retorno.numerador = this.numerador * nro;

        return retorno;

    }

    public Fraccion dividir(Fraccion fraccion) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * fraccion.numerador;
        retorno.numerador = this.numerador * fraccion.denominador;

        return retorno;

    }

    public Fraccion dividir(int nro) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * nro;
        retorno.numerador = this.numerador;

        return retorno;

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
