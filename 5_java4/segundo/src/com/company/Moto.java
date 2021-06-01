package com.company;

public class Moto extends Vehiculo {
    private static final float PESO = (float)300;
    private static final byte RUEDAS = (byte)2;

    public Moto(float velocidad, float accelaracion, float angulo_giro, String patente) {
        super(velocidad, accelaracion, angulo_giro, PESO, patente, RUEDAS);
    }
}
