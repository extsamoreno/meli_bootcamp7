package ej2;

public abstract class FiguraGeometrica {

    public abstract double area();

    @Override
    public String toString(){
        return ("El area de la Figura geometirca es de: " + area());
    }
}
