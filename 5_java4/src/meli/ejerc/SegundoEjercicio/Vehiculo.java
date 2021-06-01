package meli.ejerc.SegundoEjercicio;

public class Vehiculo {
    double velocidad;
    double aceleracion;
    double radioDeGiro;
    String patente;
    int peso;
    int cantRuedas;

    public Vehiculo(double velocidad, double aceleracion, double radioDeGiro, String patente, int peso, int cantRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.radioDeGiro = radioDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantRuedas = cantRuedas;
    }

    public Vehiculo() {
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getRadioDeGiro() {
        return radioDeGiro;
    }

    public void setRadioDeGiro(double radioDeGiro) {
        this.radioDeGiro = radioDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCantRuedas() {
        return cantRuedas;
    }

    public void setCantRuedas(int cantRuedas) {
        this.cantRuedas = cantRuedas;
    }


}
