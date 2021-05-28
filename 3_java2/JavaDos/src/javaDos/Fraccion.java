package javaDos;

public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {

    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void sumar (int numero) {

    }

    public void sumar (Fraccion fraccion) {
        Fraccion newFraccion = new Fraccion();

        newFraccion.denominador = this.denominador * fraccion.denominador;
        newFraccion.numerador = (newFraccion.denominador / this.denominador);
        denominador = this.denominador * fraccion.denominador;
    }

    public void restar (int numero) {

    }

    public void restar (Fraccion fraccion) {

    }

    public void multiplicar (int numero) {

    }

    public void multiplicar (Fraccion fraccion) {

    }

    public void dividir (int numero) {

    }

    public void dividir (Fraccion fraccion) {

    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
