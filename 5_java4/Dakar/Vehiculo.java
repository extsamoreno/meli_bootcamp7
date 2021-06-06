package Dakar;

public class Vehiculo {
    private double velocidad, aceleracion, anguloDeGiro;
    private String patente;
    private int peso, ruedas;
    
    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public float calcularMaximaVelocidad() {
        return (float) ((this.velocidad * (0.5) * this.aceleracion) /
                (this.anguloDeGiro * (this.peso - this.ruedas * 100)));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }

}
