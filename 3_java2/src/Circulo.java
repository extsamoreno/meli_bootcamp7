public class Circulo extends FiguraGeometrica{

    private double radio;
    private final double pi = Math.PI;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.pow(radio,2) * pi;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
