package tt;

public class Triangulo extends FiguraGeometrica{

    private double base, altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return (base * altura)/2;
    }
}
