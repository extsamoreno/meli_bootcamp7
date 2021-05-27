package Parte2.Figure;

public class Rectangulo extends Figure{
    public Rectangulo(int base, int altura) {
        super(base, altura);
    }

    @Override
    public double area() {
        return this.base * this.altura;
    }

    @Override
    public String toString() {
        return  "\n---- Rectangulo ----\n" +
                "Base = " + getBase() + "\n"+
                "Altura = " + getAltura()+ "\n"+
                "Área = " + area()+ " cm²";
    }
}
