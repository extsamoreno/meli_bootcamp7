package com.company;

public class Circle extends GeometricFigure {

    private double radio;

    @Override
    public double area() {
        return 3.14 * (radio * radio);
    }

    public Circle(double radio) {
        this.radio = radio;
    }
}
