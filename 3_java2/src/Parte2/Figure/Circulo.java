package Parte2.Figure;

public class Circulo extends Figure{

    int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }


    public double area() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public String toString() {
        return  "\n---- Circulo ----\n" +
                "radio = " + radio + "\n"+
                "area = " + String.format("%.3f cm²", area());
    }

}
