package Ejercicio2;

public class Moto extends Vehiculo {

    private Moto() {

        super();
        this.setPeso(300);
        this.setRuedas(2);
    }

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        super();
        this.aceleracion = aceleracion;
        this.velocidad = velocidad;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }
}
