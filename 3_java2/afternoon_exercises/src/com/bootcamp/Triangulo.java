package com.bootcamp;

public class Triangulo extends FiguraGeometrica {
    private double base, altura;

    public Triangulo(double b, double h) {
        this.base = b;
        this.altura = h;
    }

    @Override
    public double area() {
        return base * altura / 2;
    }

}
