package ejcio2_dakar;

public class Auto extends Vehiculo {

    private static final float PESO = (float) 1000;
    private static final float RUEDAS = (byte) 4;

    public Auto() {
        super();
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, PESO, patente, (byte) RUEDAS);
    }
}
