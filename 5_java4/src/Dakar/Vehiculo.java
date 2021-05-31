package Dakar;

public abstract class Vehiculo {
    private float acceleracion;
    private int velocidad;
    private float anguloDeGiro;
    private String patente;
    private float peso;
    private int ruedas;

    public Vehiculo(float acceleracion, int velocidad, float anguloDeGiro, String patente, float peso, int ruedas) {
        this.acceleracion = acceleracion;
        this.velocidad = velocidad;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public float getAcceleracion() {
        return acceleracion;
    }

    public void setAcceleracion(float acceleracion) {
        this.acceleracion = acceleracion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public float getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(float anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "acceleracion=" + acceleracion +
                ", velocidad=" + velocidad +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
