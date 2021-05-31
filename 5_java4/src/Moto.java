public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.setPeso(300);
        this.setRuedas(2);
    }
}
