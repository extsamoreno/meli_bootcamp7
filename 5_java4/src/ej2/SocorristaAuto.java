package ej2;

public class SocorristaAuto {
    public void socorrer(Auto unAuto){
        if (unAuto != null){
            System.out.println("Socorriendo auto patente: " + unAuto.patente);
            return;
        }
        System.out.println("No se encontro el auto para socorrer");
    }
}
