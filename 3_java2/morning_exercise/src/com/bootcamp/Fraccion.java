package com.bootcamp;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

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

    public void simplificar() {
        int mcd = Math.abs(MathUtils.maximoComunDivisor(this.getNumerador(), this.getDenominador()));
        this.setNumerador(this.getNumerador() / mcd);
        this.setDenominador(this.getDenominador() / mcd);
    }

    public Fraccion sumar(Fraccion f2) {
        Fraccion resultado = new Fraccion();

        int nuevoDenominador = MathUtils.minimoComunMultiplo(this.denominador, f2.getDenominador());
        resultado.setDenominador(nuevoDenominador);

        int nuevoNumerador1 = (nuevoDenominador / this.denominador) * this.numerador;
        int nuevoNumerador2 = (nuevoDenominador / f2.getDenominador()) * f2.getNumerador();
        resultado.setNumerador(nuevoNumerador1 + nuevoNumerador2);

        resultado.simplificar();

        //Actualizo el objeto que llama el método
        this.setNumerador(resultado.getNumerador());
        this.setDenominador(resultado.getDenominador());

        return resultado;
    }

    public Fraccion sumar(int entero) {
        Fraccion nuevaFraccion = new Fraccion(entero, 1);
        return sumar(nuevaFraccion);
    }

    public Fraccion restar(Fraccion f2) {
        Fraccion fr = new Fraccion(-f2.getNumerador(), f2.getDenominador());
        return sumar(fr);
    }

    public Fraccion restar(int entero) {
        Fraccion nuevaFraccion = new Fraccion(-entero, 1);
        return sumar(nuevaFraccion);
    }

    public Fraccion multiplicar(Fraccion f2) {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(this.getNumerador() * f2.getNumerador());
        resultado.setDenominador(this.getDenominador() * f2.getDenominador());

        resultado.simplificar();

        //Sobreescribo el objeto actual
        this.setNumerador(resultado.getNumerador());
        this.setDenominador(resultado.getDenominador());

        return resultado;
    }

    public Fraccion multiplicar(int entero) {
        Fraccion nuevaFraccion = new Fraccion(entero, 1);
        return multiplicar(nuevaFraccion);
    }

    public Fraccion dividir(Fraccion f2) {
        Fraccion aux = new Fraccion(f2.getDenominador(), f2.getNumerador());
        return multiplicar(aux);
    }

    public Fraccion dividir(int entero) {
        Fraccion nuevaFraccion = new Fraccion(entero, 1);
        return dividir(nuevaFraccion);
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                + numerador +
                "/" + denominador +
                '}';
    }
}
