package com.ejercitacion.tarde.dos;

public class Rectangulo extends FiguraGeometrica {

    private double altura;
    private double base;


    public Rectangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    public Rectangulo() {
    }

    @Override
    public double area() {
        return base * altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
