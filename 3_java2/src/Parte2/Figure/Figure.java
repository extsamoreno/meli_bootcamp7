package Parte2.Figure;

public abstract class Figure {

    int base;
    int altura;

    public Figure(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public Figure(){};

    public double area(){
        return 0.0;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}


