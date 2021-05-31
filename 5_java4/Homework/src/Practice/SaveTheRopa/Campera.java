package Practice.SaveTheRopa;

public class Campera extends Prenda{
    public Campera() {
    }

    public Campera(String modelo, String marca) {
        super(modelo, marca);
    }

    @Override
    public String toString() {
        return "Practice.SaveTheRopa.Campera " + super.toString();
    }
}
