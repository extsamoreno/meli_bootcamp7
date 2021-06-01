package Ex2;

public class Moto extends Vehiculo{
    private static final int pesoMoto = 300;
    private static final int ruedasMoto = 2;


    public Moto(int velocidad, int aceleracion,int anguloDeGiro,String patente) {
        this.setPeso(pesoMoto);
        this.setRuedas(ruedasMoto);
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPatente(patente);
    }

    public Moto() {
    }
}
