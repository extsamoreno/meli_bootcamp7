import java.util.ArrayList;
import java.util.List;

public class Carrera {

    Double distancia;
    Integer premioEnDolares, cantVehiculosPermitidos;
    String nombre;
    List<Vehiculo> lstVehiculos;
    SocorristaAuto socorristaAuto;
    SocorristaMoto socorristaMoto;

    public Carrera(){
        this.lstVehiculos = new ArrayList<>();
    }

    public Carrera(Double distancia, Integer premioEnDolares, Integer cantVehiculosPermitidos, String nombre, List<Vehiculo> lstVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.nombre = nombre;
        this.lstVehiculos = lstVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaMoto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro, String patente){
        if (this.lstVehiculos.size() < this.cantVehiculosPermitidos){
            Moto moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            this.lstVehiculos.add(moto);
        }
        else {
            System.out.println("Supero el maximo permitido de vehiculos");
        }
    }

    public void darDeAltaAuto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro, String patente){
        if (this.lstVehiculos.size() < this.cantVehiculosPermitidos){
            Auto auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            this.lstVehiculos.add(auto);
        }
        else {
            System.out.println("Supero el maximo permitido de vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.lstVehiculos.removeIf(v -> (v.getPatente().equals(vehiculo.getPatente())));
    }

    public void eliminarVehiculoConPatente(String patente) {
        this.lstVehiculos.removeIf(v -> (v.getPatente().equals(patente)));
    }

    public Vehiculo ganadorCarrera()
    {
        Vehiculo vehiculoGanador = new Vehiculo();
        double maxValue = 0;

        for (Vehiculo vehiculo: this.lstVehiculos) {
            double value = (vehiculo.getVelocidad() * (0.5*vehiculo.getAceleracion()))/
                    (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));

            if (value > maxValue) {
                maxValue = (vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100))));
                vehiculoGanador = vehiculo;
            }
        }

        return vehiculoGanador;
    }

/*    public void mostrarVehiculos() {
        for (int i = 0; i < lstVehiculos.size(); i++) {
            System.out.print("Vehiculo " + (i+1));
            System.out.println();
            System.out.print(lstVehiculos.get(i) + " ");
            System.out.println();
        }
    }*/

    public void socorrerAuto(String patente) {
        Vehiculo auto = this.lstVehiculos.stream().filter(a -> a.getPatente().equals(patente)).findAny().orElse(null);
        this.socorristaAuto.socorrer((Auto) auto);
    }

    public void socorrerMoto(String patente) {
        Vehiculo moto = this.lstVehiculos.stream().filter(m -> m.getPatente().equals(patente)).findAny().orElse(null);
        this.socorristaMoto.socorrer((Moto) moto);
    }


    //region Getters and Setters
    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Integer getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Integer premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public Integer getCantVehiculosPermitidos() {
        return cantVehiculosPermitidos;
    }

    public void setCantVehiculosPermitidos(Integer cantVehiculosPermitidos) {
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getLstVehiculos() {
        return lstVehiculos;
    }

    public void setLstVehiculos(List<Vehiculo> lstVehiculos) {
        this.lstVehiculos = lstVehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }
    //endregion
}
