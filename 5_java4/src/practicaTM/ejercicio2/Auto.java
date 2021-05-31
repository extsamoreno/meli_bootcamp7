package practicaTM.ejercicio2;

public class Auto extends Vehiculo {

    public Auto() {
        super();
        setRuedas(4);
        setPeso(1000);
    }

    public Auto(double velocidad, double aceleracion, double angulo, String patente) {
        super(velocidad, aceleracion, angulo, patente, 1000, 4);
    }
}
