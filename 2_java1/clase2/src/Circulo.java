import javax.crypto.Cipher;

public class Circulo extends FiguraGeometrica{

    private double radio;

    public Circulo(double radio){

        this.radio = radio;
    }

    public double area(){

        return Math.PI*Math.pow(this.radio, 2);
    }
    


    public double getRadio() {
        return radio;
    }


    public void setRadio(double radio) {
        this.radio = radio;
    }

}
