package tt;

public class Circulo extends FiguraGeometrica{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        double v = Math.PI * Math.pow(radio,2);
        return v;
    }
}
