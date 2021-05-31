package Ejercicio2;

public class Vehiculo {

    private double velocidad;
    private double aceleración;
    private double anguloDeGiro;
    private String patente;
    private int ruedas;
    private double peso;

    public Vehiculo(){

    }

    public Vehiculo(double velocidad, double aceleración, double anguloDeGiro, String patente, int ruedas, double peso) {
        this.velocidad = velocidad;
        this.aceleración = aceleración;
        this.anguloDeGiro = anguloDeGiro;
        this.patente  = patente;
        this.ruedas   = ruedas;
        this.peso     = peso;

    }


    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.anguloDeGiro = anguloDeGiro;
        this.patente  = patente;
    }


    public double performace() {
        return this.velocidad * (0.5*this.aceleración) / (anguloDeGiro*(this.peso- (this.ruedas *100)));
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleración() {
        return aceleración;
    }

    public void setAceleración(double aceleración) {
        this.aceleración = aceleración;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
