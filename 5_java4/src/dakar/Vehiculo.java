package dakar;

public abstract class Vehiculo {
    int peso,ruedas;
    String patente;
    double velocidad,aceleracion,anguloDeGiro;

    public Vehiculo(int peso,int ruedas ,String patente, double velocidad, double aceleracion, double anguloDeGiro) {
        this.peso = peso;
        this.ruedas = ruedas;
        this.patente = patente;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
    }

}
