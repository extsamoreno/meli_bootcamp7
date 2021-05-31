import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    
    public Carrera(double distancia, double premio, String nombre, int cantidadDeVehiculosPermitidos){

        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.distancia = distancia;
        this.premioEnDolares = premio;
        this.nombre = nombre;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();

    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){

        if(vehiculos.size() < this.cantidadDeVehiculosPermitidos){

            Vehiculo nuevoAuto = new Auto(velocidad, aceleracion, AnguloDeGiro, patente);
            vehiculos.add(nuevoAuto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){

        if(vehiculos.size() < this.cantidadDeVehiculosPermitidos){

            Vehiculo nuevaMoto = new Moto(velocidad, aceleracion, AnguloDeGiro, patente);
            vehiculos.add(nuevaMoto);
        }

    }

    public Vehiculo ganador(){
        
        double maxVelocidad = 0.0;
        int indexGanador = 0;

        for (int i = 0; i < this.vehiculos.size(); i++) {
            double velocidadVehiculo = this.vehiculos.get(i).calcularVelodad();
            if(velocidadVehiculo > maxVelocidad){
                maxVelocidad = velocidadVehiculo;
                indexGanador = i;
            }
        }
        return this.vehiculos.get(indexGanador);
    }


    

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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

}
