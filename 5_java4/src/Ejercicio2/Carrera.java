package Ejercicio2;

import java.util.ArrayList;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaAuto = new SocorristaAuto();
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if (this.listaDeVehiculos.size() == this.cantidadDeVehiculosPermitidos)
            System.out.println("No se puede agregar el vehiculo, no hay cupos disponibles");
        else {
            Autos auto = new Autos();
            auto.setAceleracion(aceleracion);
            auto.setPatente(patente);
            auto.setVelocidad(velocidad);
            auto.setAnguloDeGiro(anguloDeGiro);
            this.listaDeVehiculos.add(auto);
        }
    }
    public void darDeAltaMoto(int velocidad, int aceleracion ,int anguloDeGiro ,String patente) {
        if (this.listaDeVehiculos.size() == this.cantidadDeVehiculosPermitidos)
            System.out.println("No se puede agregar el vehículo, no hay cupos disponibles");
        else {
            Motos moto = new Motos();
            moto.setAceleracion(aceleracion);
            moto.setVelocidad(velocidad);
            moto.setAnguloDeGiro(anguloDeGiro);
            moto.setPatente(patente);
            this.listaDeVehiculos.add(moto);
        }
    }
    public void eliminarVehiculo(Vehiculo vehiculo) {
        for (int i=0;i<this.listaDeVehiculos.size();i++){
            if (vehiculo == this.listaDeVehiculos.get(i)) {
                this.listaDeVehiculos.remove(i);
                break;
            }
        }
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        for (int i=0;i<listaDeVehiculos.size();i++) {
            if (unaPatente == listaDeVehiculos.get(i).getPatente()){
                this.listaDeVehiculos.remove(i);
                break;
            }
        }

    }

    public void ganadorCarrera (){
        int vehiculoGanador = 0;
        double maximoValor =0;
        Vehiculo vehiculo;
        for (int i=0;i<listaDeVehiculos.size();i++) {
            vehiculo = this.listaDeVehiculos.get(i);
            double formula = vehiculo.getVelocidad() * vehiculo.getAceleracion()*0.5 /
                    (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas() * 100));
            if (formula>maximoValor) {
                maximoValor = formula;
                vehiculoGanador = i;
            }

        }
         vehiculo = listaDeVehiculos.get(vehiculoGanador);
        System.out.println("El veículo ganador es: " + (vehiculoGanador +1));

    }
    public void socorrerAuto(String patente) {
        for (int i =0; i<this.listaDeVehiculos.size();i++){
            if (patente == this.listaDeVehiculos.get(i).getPatente()) {
                this.socorristaAuto.socorrer((Autos) this.listaDeVehiculos.get(i));
                break;
            }
        }


    }
    public void socorrerMoto(String patente) {
        for (int i =0; i<this.listaDeVehiculos.size();i++){
            if (patente == this.listaDeVehiculos.get(i).getPatente()) {
                this.socorristaMoto.socorrer((Motos) this.listaDeVehiculos.get(i));
                break;
            }
        }

    }

}
