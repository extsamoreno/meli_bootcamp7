package Dakar;

public class SocorristaAuto extends Auto{
    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(velocidad,aceleracion,anguloDeGiro,patente);

    }
    public void socorrer(Auto xAuto){
        System.out.println("Socorriento auto: "+xAuto.getPatente());
    }
}
