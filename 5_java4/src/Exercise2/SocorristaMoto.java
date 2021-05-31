package Exercise2;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto(float velocidad, float accelaracion, float angulo_giro, float peso, String patente, byte ruedas) {
        super(velocidad, accelaracion, angulo_giro, peso, patente, ruedas);
    }

    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo Moto nPatente: " + unaMoto.getPatente());
    }

}
