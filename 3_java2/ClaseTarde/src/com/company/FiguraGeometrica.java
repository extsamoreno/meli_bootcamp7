package com.company;

public abstract class FiguraGeometrica {
    public abstract double area();

    public void imprimirArea()
    {
        System.out.println("Area de l figura "+area());
    }

    @Override
    public String toString() {
        return "FiguraGeometrica{}";
    }
}
