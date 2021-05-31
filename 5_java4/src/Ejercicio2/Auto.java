package Ejercicio2;

public class Auto extends Vehiculo{

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,1000,4);
    }

    public Auto() {
        this.setRuedas(4);
        this.setPeso(1000);
    }
}