package com.company;

public class Rectangle extends GeometricFigure {

    private double width;
    private double high;

    public Rectangle(double width, double high) {
        this.width = width;
        this.high = high;
    }

    @Override
    public double area() {
        return width*high;
    }
}
