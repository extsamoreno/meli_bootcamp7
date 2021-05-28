package tt;

public class Rectangulo extends FiguraGeometrica{
    private double base, altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        double v = base * altura;
        return v;
    }
}
