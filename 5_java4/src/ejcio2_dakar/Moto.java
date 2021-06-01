package ejcio2_dakar;

public class Moto extends Vehiculo {

    private static final float PESO = (float) 300;
    private static final byte RUEDAS = (byte) 2;

    public Moto() {
    }

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, PESO, patente, RUEDAS);
    }
}
