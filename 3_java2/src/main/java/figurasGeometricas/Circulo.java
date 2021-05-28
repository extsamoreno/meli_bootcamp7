package figurasGeometricas;

public class Circulo extends FiguraGeometrica{

    private double radio;

    public Circulo (double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI*this.radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
