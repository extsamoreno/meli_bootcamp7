package tt;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Sorter sorter = (Sorter<Integer>) MiFactory.getInstance("MiFactory.properties");

        Integer[] arregloEnteros = {34,1, 17,66,3,2,89,8,1};
        System.out.println("Arreglo de entrada :");
        imprimirArr(arregloEnteros);
        Comparator<Integer> comparatorNumeros = (a,b)-> a-b ;
        sorter.sort(arregloEnteros,comparatorNumeros);
        System.out.println("Arreglo ordenado :");
        imprimirArr(arregloEnteros);

        Time tiempo = new Time();

        Integer[] arregloCienMil = new Integer[100000];
        Random random = new Random(100000);
        for (int i = 0; i < 100000; i++) {
            arregloCienMil[i] = random.nextInt() ;
        }
        tiempo.start();
        sorter.sort(arregloCienMil, comparatorNumeros );
        tiempo.stop();
        System.out.println( "Tiempo de ejecucion del algoritmo : " + tiempo.elapsedTime());

    }

    public static <T> void imprimirArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
}
