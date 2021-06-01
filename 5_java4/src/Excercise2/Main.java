package Excercise2;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int op = 0;
        Carrera carrera = new Carrera();
        Scanner sc = new Scanner(System.in);

        System.out.println("Creando carrera");

        System.out.println("Nombre");
        carrera.setNombre(sc.nextLine());
        System.out.println("Cantidad de Vehiculos permitidos");
        carrera.setCantidadVehiculosPermitidos(sc.nextInt());
        System.out.println("Distancia");
        carrera.setDistancia(sc.nextInt());
        System.out.println("Premio en Dolares");
        carrera.setPremioDolares(sc.nextInt());

        carrera.setListaVehiculos(new ArrayList<Vehiculo>());
        carrera.setSocorristaAuto(new SocorristaAuto());
        carrera.setSocorristaMoto(new SocorristaMoto());
        double velocidad, aceleracion, angulo;
        String patente;
        Vehiculo vehiculo;
        do {
            System.out.println("1-Agregar Auto");
            System.out.println("2-Agregar Moto");
            System.out.println("3-Eliminar Vehiculo");
            System.out.println("4-Eliminar Vehiculo por patente");
            System.out.println("5-Calcular Ganador");
            System.out.println("6-Socorrer auto");
            System.out.println("7-Socorrer moto");
            System.out.println("8-Salir");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    if (carrera.listaVehiculos.size() < carrera.cantidadVehiculosPermitidos) {

                        System.out.println("Ingrese los datos del auto");
                        System.out.println("Ingrese la Velocidad");
                        velocidad = sc.nextDouble();
                        System.out.println("Ingrese la Aceleración");
                        aceleracion = sc.nextDouble();
                        System.out.println("Ingrese el angulo de giro");
                        angulo = sc.nextDouble();
                        System.out.println("Ingrese la patente");
                        patente = sc.next();
                        carrera.darDeAltaAuto(velocidad, aceleracion, angulo, patente);
                    } else {
                        System.out.println("La carrera esta llena");
                    }
                    System.out.println("Presione enter para continuar");
                    new java.util.Scanner(System.in).nextLine();

                    break;
                case 2:
                    if (carrera.listaVehiculos.size() < carrera.cantidadVehiculosPermitidos) {

                        System.out.println("Ingrese los datos de la Moto");
                        System.out.println("Ingrese la Velocidad");
                        velocidad = sc.nextDouble();
                        System.out.println("Ingrese la Aceleración");
                        aceleracion = sc.nextDouble();
                        System.out.println("Ingrese el angulo de giro");
                        angulo = sc.nextInt();
                        System.out.println("Ingrese la patente");
                        patente = sc.next();
                        carrera.darDeAltaMoto(velocidad, aceleracion, angulo, patente);
                    } else {
                        System.out.println("La carrera esta llena");
                    }
                    System.out.println("Presione enter para continuar");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                case 3:
                    System.out.println("Ingrese la posición del vehiculo en la lista");
                    vehiculo = carrera.listaVehiculos.get(sc.nextInt());
                    carrera.eliminarVehiculo(vehiculo);
                    System.out.println("Presione enter para continuar");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                case 4:
                    System.out.println("Ingrese la Patente");
                    carrera.eliminarVehiculoConPatente(sc.next());
                    System.out.println("Presione enter para continuar");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                case 5:
                    if (carrera.listaVehiculos.size() > 0) {
                        vehiculo = carrera.ganador();
                        System.out.println("El ganador es el vehiculo de patente " + vehiculo.getPatente() + " con " + vehiculo.getRuedas() + " ruedas.");
                    } else {
                        System.out.println("La lista debe tener almenos un vehiculo.");
                    }
                    System.out.println("Presione enter para continuar");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                case 6:
                    System.out.println("Ingrese la patente del auto");
                    carrera.socorrerMoto(sc.next());
                    System.out.println("Presione enter para continuar");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                case 7:
                    System.out.println("Ingrese la patente de la moto");
                    carrera.socorrerMoto(sc.next());
                    System.out.println("Presione enter para continuar");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                case 8:
                    System.out.println("Presione enter para salir");
                    new java.util.Scanner(System.in).nextLine();
                    break;
            }

        } while (op != 5);

    }
}
