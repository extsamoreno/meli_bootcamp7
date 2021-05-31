package Ejerciocio2;

public class Autos extends Vehiculo{

    public Autos(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,1000,4);
    }

    public Autos() {
        this.setRuedas(4);
        this.setPeso(1000);
    }
}
