import java.util.Objects;

public class Vehiculo {
    private double velocidad, aceleracion, anguloDeGiro, peso;
    private int ruedas;
    private String patente;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.ruedas = ruedas;
        this.patente = patente;
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad=velocidad;
        this.aceleracion=aceleracion;
        this.anguloDeGiro=anguloDeGiro;
        this.patente=patente;
    }

    public double maximoValor(){
        return velocidad*(((1.0/2)*aceleracion)/(anguloDeGiro*(peso-ruedas*100)));
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

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                ", patente='" + patente + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Double.compare(vehiculo.velocidad, velocidad) == 0 && Double.compare(vehiculo.aceleracion, aceleracion) == 0 && Double.compare(vehiculo.anguloDeGiro, anguloDeGiro) == 0 && Double.compare(vehiculo.peso, peso) == 0 && ruedas == vehiculo.ruedas && Objects.equals(patente, vehiculo.patente);
    }

}
