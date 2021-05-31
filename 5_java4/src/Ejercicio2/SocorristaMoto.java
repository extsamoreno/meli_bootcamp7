package Ejercicio2;

public class SocorristaMoto implements Socorista{

    public SocorristaMoto() {
    }

    @Override
    public void socorrer(Vehiculo unaMoto) {
        System.out.println("Socorriendo auto " + unaMoto.getPatente());
    }
}
