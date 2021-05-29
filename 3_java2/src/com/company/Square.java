package com.company;

public class Square extends GeometricFigure {

   private double side;

    @Override
    public double area() {
        return side *side;
    }

    public Square(double side) {
        this.side = side;
    }
}
