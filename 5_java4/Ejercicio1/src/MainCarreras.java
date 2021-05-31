public class MainCarreras {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000.0,100000.0,"Gran Carrera de Prueba",5);

        carrera.darDeAltaAuto(100.0,5.0,0.3,"ATJ298");
        carrera.darDeAltaMoto(90.0,8.0,0.2,"MIR03F");
        carrera.darDeAltaMoto(105.0,7.0,0.2,"KAR03F");
        carrera.darDeAltaMoto(120.0,6.0,0.2,"FAR03F");
        carrera.darDeAltaAuto(102.0,10.0,0.3,"PLM298");

        //Este no deberia dehar ingresarlo
        carrera.darDeAltaAuto(222.0,22.0,0.2,"ZZZ999");

        //Eliminar por placa
        carrera.eliminarVehiculoConPatente("ATJ298");
        //Eliminar vehiculo
        carrera.eliminarVehiculo(carrera.getListaVehiculos().get(1));

        System.out.println("La cantidad de vehiculos en la carrera es: " + carrera.getListaVehiculos().size());

        Vehiculo vehiculoGanador = carrera.definirGanador();

        System.out.println("El ganador es " + vehiculoGanador.getPatente());

        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        socorristaAuto.socorrerAuto((Auto) carrera.getListaVehiculos().get(2));
        socorristaMoto.socorrerMoto((Moto) carrera.getListaVehiculos().get(1));

    }
}
