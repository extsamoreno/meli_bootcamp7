package bootcamp;

public abstract class Vehiculo {
    double velocidad, aceleracion, anguloDeGiro;
    String patente;
    int peso, ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }
}
