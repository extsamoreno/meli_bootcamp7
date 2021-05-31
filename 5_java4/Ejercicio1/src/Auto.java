public class Auto extends  Vehiculo{

    public Auto() {
        super(1000.0, 4);
    }

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000.0, 4);
    }
}

