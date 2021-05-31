public class Moto extends Vehiculo{
    public Moto(String patente, double velocidad, double aceleracion, double anguloDeGiro) {
        super(300,2, patente, velocidad, aceleracion, anguloDeGiro);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "patente='" + patente + '\'' +
                '}';
    }
}
