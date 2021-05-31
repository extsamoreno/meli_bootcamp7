package Ejercicio2;

public class Auto extends Vehiculo{

    public Auto(double velocidad, double aceleración, double anguloDeGiro, String patente, int ruedas, double peso) {
        super(velocidad, aceleración, anguloDeGiro, patente, 4,  1.000);
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }
}
