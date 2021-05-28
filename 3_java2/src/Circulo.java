public class Circulo extends FiguraGeometrica{
    private double ratio;

    @Override
    public double area() {
        return ratio * ratio *  Math.PI;
    }

    @Override
    public String toString() {
        return "Es un Circulo con radio:" + ratio;
    }
}
