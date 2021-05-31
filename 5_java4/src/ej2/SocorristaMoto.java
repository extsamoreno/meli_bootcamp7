package ej2;

public class SocorristaMoto {
    public void socorrer(Moto unaMoto){
        if (unaMoto != null){
            System.out.println("Socorriendo moto patente: " + unaMoto.patente);
            return;
        }
        System.out.println("No se encontro la moto para socorrer");
    }

}
