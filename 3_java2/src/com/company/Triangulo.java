package com.company;

public class Triangulo extends FiguraGeometrica {
    //Propiedades
    private double base;
    private double altura;

    //Getters y setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }


    //Metodos
    @Override
    public double area() {
        return (base * altura) / 2;
    }
}
