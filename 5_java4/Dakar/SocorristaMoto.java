package Dakar;

public class SocorristaMoto implements Socorrista<Moto> {

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo auto " + moto.getPatente());
    }

}
