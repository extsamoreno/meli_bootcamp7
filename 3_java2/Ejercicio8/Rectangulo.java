package Ejercicio8;

public class Rectangulo extends FiguraGeometrica{
    //Atributos
    private double base, altura;
    //Constructo
    public Rectangulo(double base,double altura){
        this.base=base;
        this.altura=altura;
    }

    @Override
    public double area() {
        return base*altura;
    }
}
