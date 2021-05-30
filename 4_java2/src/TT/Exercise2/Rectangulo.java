package TT.Exercise2;

public class Rectangulo extends FiguraGeometrica{
    public int base,altura;

    public Rectangulo(int base, int altura){
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double area() {
        return base*altura;
    }
}
