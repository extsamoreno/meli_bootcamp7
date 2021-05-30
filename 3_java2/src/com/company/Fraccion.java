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
        double nuevoNumerador = fraccionSumaUna.getNumerador() + fraccionSumaDos.getNumerador();

        return new Fraccion(nuevoNumerador, fraccionSumaUna.getDenominador());
    }

    private Fraccion sumaIgualDenominador(Fraccion fraccionSumaUna, Fraccion fraccionSumaDos) {
        return null;
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
    while(i <= num1 || i <= num2)
        {
            if(num1%i==0 || num2%i==0)
            {
            mcm=mcm*i;
            if(num1%i==0) num1=num1/i;
            if(num2%i==0) num2=num2/i;
            }
            else
                i=i+1;
        }
     */
}
