package practicaTM.ejercicio2;

public class SocorristaMoto extends Vehiculo implements Socorrista {

    public void socorrer(Moto moto) {
        socorrerVehiculo(moto);
    }
}
