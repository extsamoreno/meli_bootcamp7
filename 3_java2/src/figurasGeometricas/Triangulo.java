package figurasGeometricas;

public class Triangulo extends FiguraGeometrica {
    private double altura;
    private double base;

    public Triangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }
}

