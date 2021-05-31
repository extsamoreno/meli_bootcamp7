package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    int distancia, premioEnDolares, cantidadDeVehiculosPermitidos;
    String nombre;
    List<Vehiculo> listaDeVehiculos;
    Socorrista<Auto> socorristaAuto;
    Socorrista<Moto> socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, int cantidadDeVehiculosPermitidos, String nombre) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.nombre = nombre;
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaAuto = new SocorristaAuto();
        listaDeVehiculos = new ArrayList<Vehiculo>();
    }

    public void darDeAltaAuto(String patente, double velocidad, double aceleracion,double anguloDeGiro){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        }else{
            System.out.println("Maximo cupo de vehiculos alcanzado");
        }
    };

    public void darDeAltaMoto(String patente, double velocidad, double aceleracion,double anguloDeGiro){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        }else{
            System.out.println("Cupo de vehiculos");
        }
    };

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        List<Vehiculo> filteredVehiculos =this.listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.patente.equals(unaPatente)).collect(Collectors.toList());
        //if(listVehiculos.size() > 0){
        //  eliminarVehiculo(filteredVehiculos.get(0));
        //}else {
        //  System.out.println("No se encontro el vehiculo");
        //}
        try{
            eliminarVehiculo(filteredVehiculos.get(0));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Vehiculo ganador(){
        double max = 0;
        double actual= 0;
        int winner = 0;
        Vehiculo aux;

        for ( int i = 0; i < listaDeVehiculos.size(); i++){
            aux = listaDeVehiculos.get(i);
            actual =  aux.velocidad * 0.5 * aux.aceleracion / (aux.anguloDeGiro * (aux.peso) - aux.ruedas * 100);

            if( actual > max){
                max = actual;
                winner = i;
            }

        }

        return listaDeVehiculos.get(winner);
    }

    public void socorrerAuto(String patente){
        try{
            this.socorristaAuto.socorrer(
                    (Auto) findVehiculoPatente(patente)
            );
        }catch(Exception e){
            System.out.println("No se encontro auto");
        }
    }

    public void socorrerMoto(String patente){
        try{
            this.socorristaMoto.socorrer(
                    (Moto) findVehiculoPatente(patente)
            );
        }catch (Exception e){
            System.out.println("No se encontro moto");
        }
    }

    public Vehiculo findVehiculoPatente(String patente){
        List<Vehiculo> listVehiculos = this.listaDeVehiculos.stream().filter(vehiculo ->
                vehiculo.patente.equals(patente)).collect(Collectors.toList());
        try{
            return listVehiculos.get(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
