package Dakar;

public class SocorristaMoto extends Moto {
    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }
    public void socorrer(Moto xMoto){
        System.out.println("Socorriento moto: "+xMoto.getPatente());
    }
}
