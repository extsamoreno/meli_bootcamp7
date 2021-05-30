package TT.Exercise2;

public class Circulo extends FiguraGeometrica{
    public int radio;
    public Circulo(int radio){
        this.radio = radio;
    }
    @Override
    public double area() {
        return Math.PI*Math.pow(radio,2);
    }
}
