package ejcio2_dakar;

public class SocorristaMoto implements Socorrista<Moto> {

    @Override
    public void socorrer(Moto unaMoto) {

        System.out.println("Socorriendo Moto! Patente " + unaMoto.getPatente());
    }
}
