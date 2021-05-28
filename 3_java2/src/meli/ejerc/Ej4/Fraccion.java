package meli.ejerc.Ej4;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(){
        numerador = 0;
        denominador = 0;
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion sumar (Fraccion fraccion) {
        Fraccion resultado = new Fraccion();

        resultado.denominador = this.denominador * fraccion.denominador;
        resultado.numerador = fraccion.denominador * this.numerador + this.denominador * fraccion.numerador;

        return resultado;
    }

    public Fraccion sumar (int nro) {
        Fraccion nuevaFraccion = new Fraccion();
        nuevaFraccion.numerador = nro;
        nuevaFraccion.denominador = 1;
        return sumar(nuevaFraccion);
    }

    public Fraccion restar (Fraccion fraccion) {
        Fraccion resultado = new Fraccion();

        resultado.denominador = this.denominador * fraccion.denominador;
        resultado.numerador = fraccion.denominador * this.numerador - this.denominador * fraccion.numerador;

        return resultado;
    }

    public Fraccion restar (int nro) {
        Fraccion nuevaFraccion = new Fraccion();
        nuevaFraccion.numerador = nro;
        nuevaFraccion.denominador = 1;
        return restar(nuevaFraccion);
    }

    public Fraccion multiplicar (Fraccion fraccion) {
        Fraccion resultado = new Fraccion();

        resultado.numerador = this.numerador * fraccion.numerador;
        resultado.denominador = this.denominador * fraccion.denominador;

        return resultado;
    }

    public Fraccion multiplicar (int nro) {
        Fraccion nuevaFraccion = new Fraccion();
        nuevaFraccion.numerador = nro;
        nuevaFraccion.denominador = 1;
        return multiplicar(nuevaFraccion);
    }

    public Fraccion dividir (Fraccion fraccion) {
        Fraccion resultado = new Fraccion();

        resultado.numerador = this.numerador * fraccion.denominador;
        resultado.denominador = this.denominador * fraccion.numerador;

        return resultado;
    }

    public Fraccion dividir (int nro) {
        Fraccion nuevaFraccion = new Fraccion();
        nuevaFraccion.numerador = nro;
        nuevaFraccion.denominador = 1;
        return dividir(nuevaFraccion);
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
