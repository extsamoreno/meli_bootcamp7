package ej2;

public abstract class Vehiculo {
    Integer velocidad;
    Integer aceleracion;
    Integer anguloDeGiro;
    String patente;
    Integer pesoKg;
    Integer ruedas;

    @Override
    public boolean equals(Object obj) {
        return this.patente == ((Vehiculo)obj).patente;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", pesoKg=" + pesoKg +
                ", ruedas=" + ruedas +
                '}';
    }
}
