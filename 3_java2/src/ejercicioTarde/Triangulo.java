package ejercicioTarde;

public class Triangulo extends FiguraGeometrica{
    int base;
    int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base*altura*0.5;
    }
}
