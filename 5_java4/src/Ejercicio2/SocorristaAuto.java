package Ejercicio2;

public class SocorristaAuto implements Socorista{

    public SocorristaAuto() {
    }

    public void socorrer(Vehiculo unAuto){
        System.out.println("Socorriendo auto " + unAuto.getPatente());
    }


}
