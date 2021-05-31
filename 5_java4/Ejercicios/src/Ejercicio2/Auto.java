package Ejercicio2;

public class Auto extends Vehiculo {

    private Auto() {

        super();
        this.setPeso(1000);
        this.setRuedas(4);
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        super();
        this.aceleracion = aceleracion;
        this.velocidad = velocidad;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }
}
