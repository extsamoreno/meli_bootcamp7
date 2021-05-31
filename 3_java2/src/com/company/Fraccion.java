package com.company;

public class Fraccion {

    //Propiedades
    public double numerador;
    public double denominador;

    //Getters y setters
    public double getNumerador() {
        return numerador;
    }

    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    public double getDenominador() {
        return denominador;
    }

    public void setDenominador(double denominador) {
        this.denominador = denominador;
    }

    //Contructor
    public Fraccion(double numerador, double denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    private boolean isIgualDenominador(Fraccion fraccionUno, Fraccion fraccionDos) {
        return fraccionUno.getDenominador() == fraccionDos.getDenominador();
    }

    private Fraccion sumaDistintoDenominador(Fraccion fraccionSumaUna, Fraccion fraccionSumaDos) {
        return null;
    }

    private Fraccion sumaIgualDenominador(Fraccion fraccionSumaUna, Fraccion fraccionSumaDos) {
        double nuevoNumerador = fraccionSumaUna.getNumerador() + fraccionSumaDos.getNumerador();

        return new Fraccion(nuevoNumerador, fraccionSumaUna.getDenominador());
    }

    private double getMCM(double numUno, double numDos) {
        int i = 2, mcm = 1;
        while (i <= numUno || i <= numDos) {
            if (numUno % i == 0 || numDos % i == 0) {
                mcm = mcm * i;
                if (numUno % i == 0) numUno = numUno / i;
                if (numDos % i == 0) numDos = numDos / i;
            } else
                i++;
        }
        return mcm;
    }

    public Fraccion suma(Fraccion fraccionSumaUna, Fraccion fraccionSumaDos) {
        if (isIgualDenominador(fraccionSumaUna, fraccionSumaDos))
            return sumaIgualDenominador(fraccionSumaUna, fraccionSumaDos);
        else
            return sumaDistintoDenominador(fraccionSumaUna, fraccionSumaDos);
    }

    public Fraccion suma(Fraccion fraccionSumaUna, int enteroSuma) {
        return suma(fraccionSumaUna, new Fraccion(enteroSuma, 1));
    }


    /*

     */
}
