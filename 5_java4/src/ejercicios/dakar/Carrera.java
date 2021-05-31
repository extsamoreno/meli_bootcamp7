package ejercicios.dakar;

import java.util.ArrayList;

public class Carrera {
    private int distancia,premioEnDolares,CantidadDeVehiculosPermitidos;
    private String nombre;
    private ArrayList<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();


    public Carrera(int distancia, int premioEnDolares, int CantidadDeVehiculosPermitidos, String nombre, ArrayList<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.CantidadDeVehiculosPermitidos = CantidadDeVehiculosPermitidos;
        this.nombre = nombre;
        this.listaDeVehiculos=listaDeVehiculos;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return CantidadDeVehiculosPermitidos;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void darDeAltaAuto(float velocidad,float aceleracion,float anguloDeGiro,String patente){
        if (listaDeVehiculos.size()<getCantidadDeVehiculosPermitidos()){
            Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro, patente);
            this.listaDeVehiculos.add(auto);
            System.out.println("Auto patente: " + patente + " agregado a la carrera: " + this.nombre);
        }else {
            System.out.println("No se permiten mas autos");
        }
    }

    public void darDeAltaMoto(float velocidad,float aceleracion,float anguloDeGiro,String patente){
        if (listaDeVehiculos.size()<getCantidadDeVehiculosPermitidos()){
            Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro, patente);
            this.listaDeVehiculos.add(moto);
            System.out.println("Moto patente: " + patente + " agregada a la carrera: " + this.nombre);
        }else{
            System.out.println("No se permiten mas motos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if (listaDeVehiculos.get(i).getPatente().equals(vehiculo.getPatente())){
                listaDeVehiculos.remove(i);
                System.out.println("Se eliminó el objeto vehiculo!");
                return;
            }
        }
        System.out.println("No se encontro el vehiculo");
    }

    public void eliminarVehiculoPorPatente(String patente) {
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if (listaDeVehiculos.get(i).getPatente().equals(patente)) {
                listaDeVehiculos.remove(i);
                System.out.println("Se eliminó el vehiculo patente: " + patente);
                return;
            }
        }
        System.out.println("No se encontro el vehiculo");
    }

    public void ganadorDeCarrera(){
        float valorMaximo = 0;
        int index = 0;
        for (int i = 0; i < listaDeVehiculos.size() ; i++) {
            float velocidad = listaDeVehiculos.get(i).getVelocidad();
            float aceleracion = listaDeVehiculos.get(i).getAceleracion();
            float anguloDeGiro= listaDeVehiculos.get(i).getAnguloDeGiro();
            float peso = listaDeVehiculos.get(i).getPeso();
            float cantidadDeRuedas = listaDeVehiculos.get(i).getRuedas();

            float valor = (float) ((velocidad*(aceleracion*0.5))/(anguloDeGiro*(peso-(cantidadDeRuedas*100))));

            if (valor>=valorMaximo){
                valorMaximo=valor;
                index = i;
            }
        }
        System.out.println("El vehiculo patente: " + listaDeVehiculos.get(index).getPatente() + " gano la carrera con puntaje: " + valorMaximo);
    }

    public void socorrerAuto (String patente){
        for (int i = 0; i < listaDeVehiculos.size() ; i++) {
            if (listaDeVehiculos.get(i).getPatente().equals(patente)){
                Vehiculo autorescatado = listaDeVehiculos.get(i);
                socorristaAuto.socorrer((Auto) autorescatado);
                return;
            }
        }
        System.out.println("No se encuentra la patente ("+patente+") del auto socorrer");
    }

    public void socorrerMoto (String patente){
        for (int i = 0; i < listaDeVehiculos.size() ; i++) {
            if (listaDeVehiculos.get(i).getPatente().equals(patente)){
                Vehiculo motorescatada = listaDeVehiculos.get(i);
                socorristaMoto.socorrer((Moto) motorescatada);
                return;
            }
        }
        System.out.println("No se encuentra la patente("+ patente + ")de la moto a socorrer");
    }
}
