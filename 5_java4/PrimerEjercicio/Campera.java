package PrimerEjercicio;

public class Campera extends Prenda{

    public Campera() {
    }

    public Campera(String modelo, String marca) {
        super(modelo, marca);
    }

    @Override
    public String toString() {
        return "Campera"+super.toString();
    }
}
