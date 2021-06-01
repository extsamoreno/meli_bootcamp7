package Ex2;

public class SocorristaAuto extends Auto{
    public SocorristaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public SocorristaAuto() {
    }

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo Auto " + unAuto.getPatente());
    }
}
