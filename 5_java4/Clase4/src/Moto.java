public class Moto extends Vehiculo{

    public static final int RUEDAS = 2;
    public static final double PESO = 300.00;
    
    public Moto( double velocidad, double aceleracion, double anguloDeGiro, String patente){

        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);

    }
    
}
