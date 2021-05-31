package ejercicioTarde;

public class Circulo extends FiguraGeometrica{
    int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI*radio*radio;
    }
}
