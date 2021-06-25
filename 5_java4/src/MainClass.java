import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        List<FuegosArtificiales> list= new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new FuegosArtificialesIndiv());
        }
        for (int i = 0; i < 20; i++) {
            FuegosArtificialesPack x = new FuegosArtificialesPack();
            for (int j = 0; j < 5; j++) {
                x.agregarFuegoArtificial(new FuegosArtificialesIndiv());
            }
            list.add(x);
        }
        System.out.println("Numero total de fuegos artificiales: "+Evento.contarFuegosArtificiales(list));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).explotar();
        }

    }

    private static void ejercicio2() {
        Carrera c1= new Carrera();
        c1.setDistancia(500);
        c1.setPremioEnDolares(2000);
        c1.setNombre("MELICarrera");
        c1.setCantidadDeVehiculosPermitidos(4);
        c1.setSocAuto(new SocorristaAuto(100, 30, 14,"CHEVROLET"));
        c1.setSocMoto(new SocorristaMoto(120, 40, 20, "MAZDA"));

        // dando de alta autos y motos a la carrera
        c1.darDeAltaAuto(300, 100, 100, "LAMBORGUINI");
        c1.darDeAltaMoto(280, 140, 150, "KIA");
        c1.darDeAltaAuto(320, 130, 200, "KIMCO");
        c1.darDeAltaMoto(300, 200, 200, "BMW");
        // Vehiculo para probar numero maximo de vehiculos permitidos en la carrera
        c1.darDeAltaAuto(400, 120, 90, "SsangJong");

        // eliminando vehiculos de la carrera
        c1.eliminarVehiculo(new Auto(300,100,100,"LAMBORGUINI")); //Este existe
        c1.eliminarVehiculo(new Auto(0,0,0,"")); //Este no
        c1.eliminarVehiculoConPatente("KIA"); //Este existe
        c1.eliminarVehiculoConPatente("HOLA"); //Este no

        // calcular el ganador de la carrera
        calcularGanador(c1);

        // socorrer auto y moto
        c1.socorrerAuto("KIMCO"); //Este existe
        c1.socorrerMoto("HOLA"); //Este no
    }

    private static void ejercicio1() {
        Prenda prenda1= new Prenda("Pantalon Campanero","Soul Train");
        Prenda prenda2= new Prenda("Camisa corta","Gucci");
        List<Prenda> listaDePrendas= new ArrayList<Prenda>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);
        System.out.println("Sus prendas quedaron guardadas con el identificador "+GuardaRopa.guardarPrendas(listaDePrendas));
        Scanner entrada= new Scanner(System.in);
        System.out.print("Ingrese el indentificador de sus prendas: ");
        Integer id= entrada.nextInt();
        System.out.println("Las prendas encontradas en el identificador correspondiente fueron: ");
        for (int i = 0; i < GuardaRopa.devolverPrendas(id).size(); i++) {
            System.out.print(GuardaRopa.devolverPrendas(id).get(i)+"\n");
        }
    }

    private static void calcularGanador(Carrera c1){
        List<Vehiculo> list= c1.getListaDeVehiculos();
        double max=0;
        Vehiculo vMax= null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).maximoValor()>max) {
                max=list.get(i).maximoValor();
                vMax=list.get(i);
            }
        }
        System.out.println("El ganador de la carrera fue "+vMax);
        System.out.printf("Con un puntaje de %.4f \n",max);
    }
}
