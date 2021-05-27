package com.company.ej4;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador) {
        this.numerador = numerador;
        this.denominador = 1;
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

        return retorno.simplificar();

    }

    public Fraccion sumar(int nro) {

        return this.sumar(new Fraccion(nro));

    }

    public Fraccion restar(Fraccion fraccion) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * fraccion.denominador;
        retorno.numerador = ( retorno.denominador / this.denominador * this.numerador ) -
                ( retorno.denominador / fraccion.denominador * fraccion.numerador );

        return retorno.simplificar();

    }

    public Fraccion restar(int nro) {

        return this.restar(new Fraccion(nro));

    }

    public Fraccion multiplicar(Fraccion fraccion) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * fraccion.denominador;
        retorno.numerador = this.numerador * fraccion.numerador;

        return retorno.simplificar();

    }

    public Fraccion multiplicar(int nro) {

        return this.multiplicar(new Fraccion(nro));

    }

    public Fraccion dividir(Fraccion fraccion) {

        Fraccion retorno = new Fraccion();

        retorno.denominador = this.denominador * fraccion.numerador;
        retorno.numerador = this.numerador * fraccion.denominador;

        return retorno.simplificar();

    }

    public Fraccion dividir(int nro) {

        return this.dividir(new Fraccion(nro));

    }

    private int mcdRecursivo(int a, int b) {

        if(b == 0) {
            return a;
        }
        return mcdRecursivo(b, a % b);

    }

    private Fraccion simplificar() {

        int mcd = mcdRecursivo(this.numerador,this.denominador);

        if(mcd == 1) {
            return this;
        }

        this.numerador /= mcd;
        this.denominador /= mcd;

        return this;

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

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}
