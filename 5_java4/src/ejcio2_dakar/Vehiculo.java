package ejcio2_dakar;

import java.util.Objects;

public abstract class Vehiculo {

    private double velocidad, aceleracion, anguloDeGiro, peso;
    private String patente;
    private byte ruedas;

    public Vehiculo() {
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, double peso, String patente, byte ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.patente = patente;
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", peso=" + peso +
                ", patente='" + patente + '\'' +
                ", ruedas=" + ruedas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Double.compare(vehiculo.velocidad, velocidad) == 0 && Double.compare(vehiculo.aceleracion, aceleracion) == 0 && Double.compare(vehiculo.anguloDeGiro, anguloDeGiro) == 0 && Double.compare(vehiculo.peso, peso) == 0 && ruedas == vehiculo.ruedas && patente.equals(vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocidad, aceleracion, anguloDeGiro, peso, patente, ruedas);
    }

    // Getters & Setters
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

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public byte getRuedas() {
        return ruedas;
    }

    public void setRuedas(byte ruedas) {
        this.ruedas = ruedas;
    }
}
