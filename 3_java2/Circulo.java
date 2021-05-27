public class Circulo extends FiguraGeometrica{
    private int radio;


    //contructores
    public Circulo() {
    }

    public Circulo(int radio) {
        this.radio = radio;
    }

    //get and set
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }



    @Override
    public double area() {
        return Math.PI * Math.pow(radio,2);
    }


}
