package com.company;

public abstract class GeometricFigure {

    private double area;

    public abstract double area();


    @Override
    public String toString() {
        return "Area = { " + this.area + '}';
    }
}
