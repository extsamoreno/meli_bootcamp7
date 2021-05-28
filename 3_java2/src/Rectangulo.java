public class Rectangulo extends FiguraGeometrica{
    private double height;
    private double base;

    @Override
    public double area() {
        return (height * base);
    }
    @Override
    public String toString(){
        return "Es un triangulo de altura: " +base+ " y lado: " + height;
    }
}
