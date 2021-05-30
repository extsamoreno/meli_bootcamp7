package TT.Exercise2;

public class Triangulo extends FiguraGeometrica{
    public int base,altura;
    public Triangulo(int base, int altura){
        this.base = base;
        this.altura=altura;
    }
    @Override
    public double area() {
        return base*altura/2;
    }
}
