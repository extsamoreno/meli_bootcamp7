package Exercise2;

public class SocorristaAuto extends Vehiculo{

    public SocorristaAuto(float velocidad, float accelaracion, float angulo_giro, float peso, String patente, byte ruedas) {
        super(velocidad, accelaracion, angulo_giro, peso, patente, ruedas);
    }

    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo Auto nPatente: " + unAuto.getPatente());
    }
}
