public class Rectangulo extends FiguraGeometrica{
    private float lado1;
    private float lado2;


    @Override
    public String toString() {
        return "Rectangulo{" +
                "lado" + lado1 + "lado2" + lado2 +
                '}';
    }

    @Override
    public double area() {
        return this.lado1*this.lado2;
    }
}
