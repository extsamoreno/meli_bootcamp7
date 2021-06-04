package DakarExercise;

import java.util.*;

public class Carrera implements Evento<Carrera>{
    private int distancia;
    private int premioDolares;
    private String nombre;
    private int cupoMax;
    private List<Vehiculo> lsVehiculos;


    public List<Vehiculo> getLsVehiculos() {
        return lsVehiculos;
    }


    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }


    @Override
    public <T> void altaAuto(int v, int a, int aG, String p) {

        if (getCupoMax() - getLsVehiculos().size() > 0)
        {
            Auto auto = new Auto(v,a,aG, p);
            getLsVehiculos().add();
        }
    }

    @Override
    public <T> void altaMoto(int v, int a, int aG, String p) {

    }

    @Override
    public <T> void altaV(int v, int a, int aG, String p) {
        if (getCupoMax() - getLsVehiculos().size() > 0)
        {
            <T> v = new T(v,a,aG,p);
            getLsVehiculos().add(v);
        }
    }

    @Override
    public <T> void eliminarVehiculo() {

    }

    @Override
    public <T> void eliminarVehiculoPatente() {

    }
}
