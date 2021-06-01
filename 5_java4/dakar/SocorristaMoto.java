package dakar;

public class SocorristaMoto extends dakar.Vehiculo {
    public void socorrer(dakar.Auto moto) {
        System.out.println("Socorriendo a la moto con patente " + moto.getPatente());
    }
}