package meli.ejerc.Ej2Tarde;

public class Rectangulo extends FiguraGeometrica{
    private double ladoA;
    private double ladoB;

    public Rectangulo(double ladoA, double ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public double area() {
        return ladoA * ladoB;
    }
}
