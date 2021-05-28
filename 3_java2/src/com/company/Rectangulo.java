package com.company;

public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    @Override
    public double area() {
        return base * altura;
    }
}
