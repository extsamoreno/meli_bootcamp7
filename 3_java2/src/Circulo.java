public class Circulo extends FiguraGeometrica{
    private float radio;

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(this.radio,2);
    }
}
