package SegundoEjercicio;

public class SocorristaAuto extends Vehiculo implements Socorrista {

    @Override
    public void socorrer(Vehiculo vehiculo) throws DakarException {
        if (vehiculo instanceof Auto) {
            System.out.println("Socorriendo: " + vehiculo);
        } else throw new DakarException("Solo puedo socorrer autos");
    }

}