package Ejerciocio2;

public class SocorristaMoto extends Vehiculo{

    public void socorrer(Vehiculo unaMoto){
        System.out.println("Socorriendo a la moto: " + unaMoto.getPatente());
    }

    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public SocorristaMoto() {
    }
}