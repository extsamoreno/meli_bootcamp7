public class Triangulo extends FiguraGeometrica{
    private double height;
    private double base;

    @Override
    public double area() {
        return (base * height) /2;
    }
    @Override
    public String toString(){
        return "Es un triangulo de altura: " +height+ " y base: " + base;
    }
}
