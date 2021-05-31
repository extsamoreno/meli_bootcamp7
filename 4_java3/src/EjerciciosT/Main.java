package EjerciciosT;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Comparator<Integer> compAscInt = (a, b) -> b - a;
        //Integer arr[] = {1, 10, 5, 7, 3, 4, 20};
        Integer arr[] = createIntArr(100000);
        
        Comparator<String> compAscString = (a, b) -> b.compareTo(a);
        String arrS[] = {"pepe", "juan", "andrea", "roberto", "valeria", "carlos"};

        /*// QUICK SORT //
        // Ordenando ints
        new QuickSortSorterImple().sort(arr, compAscInt);
        System.out.println("\nQUICK SORT");
        printArr(arr);

        // Ordenando strings
        new QuickSortSorterImple().sort(arrS, compAscString);
        printArr(arrS);

        //-----------------------------//

        // HEAP SORT //
        // Ordenando ints
        System.out.println("\nHEAP SORT");
        new HeapSortSorterImple().sort(arr, compAscInt);
        printArr(arr);

        // Ordenando strings
        new HeapSortSorterImple().sort(arrS, compAscString);
        printArr(arrS);

        //-----------------------------//

        // BUBBLE SORT //
        // Ordenando ints
        System.out.println("\nBUBBLE SORT");
        new BubbleSortSorterImple().sort(arr, compAscInt);
        printArr(arr);

        // Ordenando strings
        new BubbleSortSorterImple().sort(arrS, compAscString);
        printArr(arrS);*/

        //-----------------------------//

        // MI FACTORY y TIMER //
        // Ordenar Ints
        Sorter sInt = (Sorter<Integer>) MiFactory.getInstance("sorter");
        Time timer = new Time();

        timer.start();
        sInt.sort(arr, compAscInt);
        //printArr(arr);
        timer.stop();
        System.out.println("Tiempo de ejecucion en milisegundos: " + timer.elapsedTime());

        /*// Ordenar Strings
        Sorter sArray = (Sorter<String>) MiFactory.getInstance("sorter");

        timer.start();
        sArray.sort(arrS, compAscString);
        printArr(arrS);
        timer.stop();
        System.out.println("Tiempo de ejecucion en milisegundos: " + timer.elapsedTime());*/

    }

    // Print Array
    public static <T> void printArr(T[] arr) {

        System.out.println("\n");

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }

    // Create random Integer Array
    public static Integer[] createIntArr(int arrSize){

        Integer[] arr = new Integer[arrSize];
        Random random = new Random();

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = random.nextInt(100000);
        }

        return arr;
    }
}
