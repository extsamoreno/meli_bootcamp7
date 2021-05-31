package dakar;

public class Auto extends Vehiculo{

    public Auto (double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, 1000, patente, 4);
    }
}
