package Exercise2;

public class Auto extends Vehiculo {
    private static final float PESO = (float)1000;
    private static final byte RUEDAS = (byte)4;

    public Auto(float velocidad, float accelaracion, float angulo_giro, String patente) {
        super(velocidad, accelaracion, angulo_giro, PESO, patente, RUEDAS);
    }

}
