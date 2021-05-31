public class Moto extends Vehiculo {

    public Moto() {
        super(300.0, 2);
    }

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300.0, 2);
    }
}
