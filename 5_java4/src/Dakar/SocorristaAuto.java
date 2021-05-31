package Dakar;

public class SocorristaAuto implements Socorrista<Auto>{
    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo Auto - Patente: " + vehiculo.getPatente());
    }
}
