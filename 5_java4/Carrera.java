import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    int distancia,premioEnDolares,cantidadVehiculos;
    String nombre;
    List<Vehiculo> vehiculos;
    Socorrista<Auto> socorristaAuto;
    Socorrista<Moto> socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, int cantidadVehiculos, String nombre) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.cantidadVehiculos = cantidadVehiculos;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<Vehiculo>(cantidadVehiculos);
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaAuto = new SocorristaAuto();
    }

    public void darDeAltaAuto(String patente, double velocidad, double aceleracion, double anguloDeGiro){
        if(vehiculos.size() != cantidadVehiculos){
            Auto auto = new Auto(patente,velocidad,aceleracion,anguloDeGiro);
            vehiculos.add(auto);
        }else{
            System.out.println("No se puede agregar mas autos a la carrera");
        }
    }

    public void darDeAltaMoto(String patente, double velocidad, double aceleracion, double anguloDeGiro){
        if(vehiculos.size() != cantidadVehiculos){
            Moto moto = new Moto(patente,velocidad,aceleracion,anguloDeGiro);
            vehiculos.add(moto);
        }else{
            System.out.println("No se puede agregar mas motos a la carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
            try{
            eliminarVehiculo(
                    findVehiculoPatente(unaPatente)
            );
            }catch (Exception e){
                System.out.println("No se pudo eliminar");
            }
    }

    public Vehiculo findVehiculoPatente(String patente){
        List<Vehiculo> listVehiculos = this.vehiculos.stream().filter(vehiculo ->
                vehiculo.patente.equals(patente)).collect(Collectors.toList());
        try{
            return listVehiculos.get(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Vehiculo ganador(){
        double max = 0;
        double actual= 0;
        int winner = 0;
        Vehiculo aux;

        for ( int i = 0; i < vehiculos.size(); i++){
            aux = vehiculos.get(i);
            actual =  aux.velocidad * 0.5 * aux.aceleracion / (aux.anguloDeGiro * (aux.peso) - aux.ruedas * 100);

            if( actual > max){
                max = actual;
                winner = i;
            }

        }

        return vehiculos.get(winner);
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


}
