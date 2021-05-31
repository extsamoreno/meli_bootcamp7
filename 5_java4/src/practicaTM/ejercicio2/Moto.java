package practicaTM.ejercicio2;

public class Moto extends Vehiculo {

    public Moto() {
        super();
        setRuedas(2);
        setPeso(300);
    }

    public Moto(double velocidad, double aceleracion, double angulo, String patente) {
        super(velocidad, aceleracion, angulo, patente, 300, 2);
    }

    @Override
    public String toString() {
        return "Moto{Patente: "+getPatente()+"}";
    }
}
