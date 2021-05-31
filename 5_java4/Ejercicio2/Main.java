public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        carrera.setCantVehiculosPermitidos(10);

        carrera.darDeAltaMoto(115 ,35,50,"c 323x");
        carrera.darDeAltaMoto(90 ,35,50,"a 123b");
        carrera.darDeAltaAuto(160 ,55,45,"abc 123");
        carrera.darDeAltaMoto(130 ,47,63,"c 323x");
        carrera.darDeAltaAuto(190 ,50,50,"djy 888");
        carrera.darDeAltaAuto(155 ,65,55,"pkh 758");
        carrera.darDeAltaAuto(160 ,70,63,"yjk 599");

        Moto moto = new Moto(130, 47,65,"c 323x");
        carrera.eliminarVehiculo(moto);
        carrera.eliminarVehiculoConPatente("abc 123");

        SocorristaMoto socorristaMoto = new SocorristaMoto();
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        carrera.setSocorristaAuto(socorristaAuto);
        carrera.setSocorristaMoto(socorristaMoto);
        carrera.socorrerAuto("djy 888");
        carrera.socorrerMoto("a 123b");

        Vehiculo vehiculoGanador = carrera.ganadorCarrera();
        System.out.println("Vehiculo ganador: " + vehiculoGanador.toString());
    }

    private static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
    }
}
