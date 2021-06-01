package Ex2;

public class SocorristaMoto extends Moto{
    public SocorristaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public SocorristaMoto() {
    }

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo Moto " + unaMoto.getPatente());
    }

}
