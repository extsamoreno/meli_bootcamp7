package dakar;

public class SocorristaAuto extends dakar.Vehiculo {
    public void socorrer(dakar.Auto auto) {
        System.out.println("Socorriendo al auto de patente " + auto.getPatente());
    }
}