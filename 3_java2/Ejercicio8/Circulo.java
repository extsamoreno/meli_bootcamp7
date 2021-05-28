package Ejercicio8;

public class Circulo extends  FiguraGeometrica{
    //Atributos
    private double radio;

    public Circulo(int r){
        this.radio=r;
    }

    @Override
    public double area() {

        return Math.PI*Math.pow(radio,2);
    }
}
