public class Rectangulo extends FiguraGeometrica{

    private double alto;
    private double ancho;

    public Rectangulo(double alto, double ancho){

        this.alto = alto;
        this.ancho = ancho;
    }

    public double area(){

        return (this.ancho*this.alto);
    }
    


    public double getAlto() {
        return alto;
    }


    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

}
