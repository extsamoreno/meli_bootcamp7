package dakar;

public class SocorristaAuto implements VehiculoSocorrista<Auto>{

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto...");
        System.out.println("Patente: " + vehiculo.getPatente());
    }
}
