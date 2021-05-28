package meli.ejerc;

public class Fraccion {
    private int denominador;
    private int numerador;

    public void Fraccion() {
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

    public Fraccion suma(Fraccion frac1, Fraccion frac2) {
        Fraccion resultado = new Fraccion();

        resultado.setNumerador(frac1.getNumerador() * frac2.getNumerador() + frac2.getNumerador() * frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador() * frac2.getDenominador());

        return resultado;
    }

    public Fraccion suma(Fraccion frac1, int num) {
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador() * fracAux.getNumerador() + fracAux.getNumerador() * frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador() * fracAux.getDenominador());

        return resultado;
    }

    public Fraccion sumar(Fraccion a, int num) {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador() * 1 + (num * a.getDenominador()));
        resultado.setDenominador(a.getDenominador() * 1);

        return resultado;
    }

    public Fraccion resta(Fraccion frac1, Fraccion frac2) {
        Fraccion resultado = new Fraccion();

        resultado.setNumerador(frac1.getNumerador() * frac2.getNumerador() - frac2.getNumerador() * frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador() * frac2.getDenominador());

        return resultado;
    }

    public Fraccion resta(Fraccion frac1, int num) {
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador() * fracAux.getNumerador() - fracAux.getNumerador() * frac1.getDenominador());
        resultado.setDenominador(frac1.getDenominador() * fracAux.getDenominador());

        return resultado;
    }

    public Fraccion multiplar(Fraccion a, Fraccion b) {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(a.getNumerador() * b.getNumerador());
        resultado.setDenominador(a.getDenominador() * b.getDenominador());
        return resultado;
    }

    public Fraccion multiplar(Fraccion frac1, int num) {
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador() * fracAux.getNumerador());
        resultado.setDenominador(frac1.getDenominador() * fracAux.getDenominador());
        return resultado;
    }

    public Fraccion dividir(Fraccion frac1, Fraccion frac2) {
        Fraccion resultado = new Fraccion();
        resultado.setNumerador(frac1.getNumerador() * frac2.getDenominador());
        resultado.setDenominador(frac1.getDenominador() * frac2.getNumerador());
        return resultado;
    }


    public Fraccion dividir(Fraccion frac1, int num) {
        Fraccion resultado = new Fraccion();
        Fraccion fracAux = new Fraccion();
        fracAux.setNumerador(num);
        fracAux.setDenominador(1);

        resultado.setNumerador(frac1.getNumerador() * fracAux.getDenominador());
        resultado.setDenominador(frac1.getDenominador() * fracAux.getNumerador());
        return resultado;
    }
}
