package ejcio2_dakar;

public class SocorristaAuto implements Socorrista<Auto> {

    @Override
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo Auto! Patente " + unAuto.getPatente());
    }

}
