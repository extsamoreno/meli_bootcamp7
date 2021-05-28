package com.bootcamp;

public class Rectangulo extends FiguraGeometrica {

    private double base, altura;

    public Rectangulo(double b, double h) {
        this.base = b;
        this.altura = h;
    }

    @Override
    public double area() {
        return base * altura;
    }

}
