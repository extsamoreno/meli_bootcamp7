package com.company.CT.Ejercicio_2;

public class Rectangulo extends FiguraGeometrica {
    private double base,altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base*altura;
    }
}
