package Parte2.Figure;

public class Triangulo extends Figure{

    public Triangulo(int base, int altura) {
        super(base,altura);
    }

    @Override
    public String toString() {
        return  "\n--- Triangulo ---\n" +
                "base = " + base + "\n" +
                "altura = " + altura + "\n" + "area = "  + area() + " cm²";
    }

    @Override
    public double area(){
        return (this.base * this.altura) / 2.0;
    }


}
