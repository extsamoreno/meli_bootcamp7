import java.util.*;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda();
        prenda1.marca = "Nike";
        prenda1.modelo = "Pantalon";

        Prenda prenda2 = new Prenda();
        prenda2.marca = "DC";
        prenda2.modelo = "Zapatilla";

        Prenda prenda3 = new Prenda();
        prenda3.marca = "Marca Test";
        prenda3.modelo = "Modelo Test";

        List<Prenda> lstPrenda = new ArrayList<>();
        lstPrenda.add(prenda1);
        lstPrenda.add(prenda2);

        List<Prenda> lstPrenda2 = new ArrayList<>();
        lstPrenda2.add(prenda3);

        GuardaRopa gRopa = new GuardaRopa();
        gRopa.guardarPrendas(lstPrenda);
        gRopa.guardarPrendas(lstPrenda2);

        //gRopa.guardarPrendas(lstPrenda2);
        //gRopa.mostrarPrendas();
        System.out.println(gRopa.devolverPrendas(2));
    }

    private static void printArray(Integer arr[], Long miliSec)
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println("Demoró: " + miliSec + " Milisegundos");

    }
}
