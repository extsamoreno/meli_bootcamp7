public class Auto extends Vehiculo{
    public Auto(String patente, double velocidad, double aceleracion, double anguloDeGiro) {
        super(1000,4, patente, velocidad, aceleracion, anguloDeGiro);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "patente='" + patente + '\'' +
                '}';
    }
}
