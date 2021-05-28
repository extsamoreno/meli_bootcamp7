package Ejercicio8;

public class Triangulo extends FiguraGeometrica{

    //Atributos

    private double base, altura;
    //Constructo
    public Triangulo(double base,double altura){
        this.base=base;
        this.altura=altura;
    }

    @Override
    public double area() {
        return (base*altura)/2;
    }
}
