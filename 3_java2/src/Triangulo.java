public class Triangulo extends FiguraGeometrica{
    private float base;
    private float altura;

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                '}';
    }

    @Override
    public double area() {
        return this.base*this.altura;
    }
}
