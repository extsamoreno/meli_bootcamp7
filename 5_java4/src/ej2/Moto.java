package ej2;

public class Moto extends Vehiculo{
    public Moto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro, String patente) {
        this.pesoKg = 300;
        this.ruedas = 2;
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }
}
