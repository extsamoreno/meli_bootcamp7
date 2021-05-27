package com.ejercitacion.tarde.dos;

public class Triangulo extends FiguraGeometrica {

    private double altura;
    private double base;

    public Triangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    public Triangulo() {
    }

    @Override
    public double area() {
        return altura * base / 2;
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
