package Dakar;

public class SocorristaMoto implements Socorrista<Moto>{

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo Moto - Patente: "+ vehiculo.getPatente());
    }
}
