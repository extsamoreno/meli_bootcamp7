package dakar;

public class SocorristaMoto implements VehiculoSocorrista<Moto>{
    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto...");
        System.out.println("Patente: " + vehiculo.getPatente());
    }
}
