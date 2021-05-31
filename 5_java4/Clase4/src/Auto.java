public class Auto extends Vehiculo{

    public static final int RUEDAS = 4;
    public static final double PESO = 1000.00;
    
    public Auto( double velocidad, double aceleracion, double anguloDeGiro, String patente){

        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);

    }
}
