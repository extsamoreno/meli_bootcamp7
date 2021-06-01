package Ex2;

public class Auto extends Vehiculo{
    private static final int pesoAuto = 1000;
    private static final int ruedasAuto = 4;


    public Auto(int velocidad, int aceleracion,int anguloDeGiro,String patente) {
        this.setPeso(pesoAuto);
        this.setRuedas(ruedasAuto);
        this.setVelocidad(velocidad);
        this.setAceleracion(aceleracion);
        this.setAnguloDeGiro(anguloDeGiro);
        this.setPatente(patente);
    }

    public Auto() {
    }
}
