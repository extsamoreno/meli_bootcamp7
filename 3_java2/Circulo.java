public class Circulo extends FiguraGeometrica{

    private double pi = 3.14159265359;
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getPi() {
        return pi;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return this.pi * Math.pow(this.radio,2);
    }

}
