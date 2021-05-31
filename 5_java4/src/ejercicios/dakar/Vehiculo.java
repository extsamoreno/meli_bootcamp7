package ejercicios.dakar;

public abstract class Vehiculo {
    private float velocidad, aceleracion, anguloDeGiro;
    String patente;
    int ruedas, peso;

    public Vehiculo(float velocidad, float aceleracion, float anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public float getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public int getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }
}
