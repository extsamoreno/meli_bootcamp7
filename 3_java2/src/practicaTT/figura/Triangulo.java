package practicaTT.figura;

public class Triangulo extends FiguraGeometrica {
    double base;
    double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura / 2;
    }

    @Override
    public String toString() {
        return "Triangulo de base y altura: " + base + ", " + altura + ", Area: " + this.area();
    }
}
