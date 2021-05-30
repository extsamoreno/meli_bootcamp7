package practicaTT;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Random;

public class Main {
    // preguntar si es buena practica
    // colocar todos los throws o usar try catch
    // si van las excepciones especificas o se coloca una mas general
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Comparator<Integer> compAscInt = (a, b) -> b - a;
        Comparator<String> compAscStr = (a, b) -> b.compareTo(a);

        Sorter quick = new QuickSortSorterImple();
        Sorter heap = new HeapSortSorterImple();
        Sorter bubble = new BubbleSortSorterImple();

        System.out.println("Using SORTERS:");
        sortAndPrintArray(compAscInt, quick, getIntegersArray(), true);
        sortAndPrintArray(compAscInt, heap, getIntegersArray(), true);
        sortAndPrintArray(compAscInt, bubble, getIntegersArray(), true);
        System.out.println("--------");
        sortAndPrintArray(compAscStr, quick, getStringsArray(), true);
        sortAndPrintArray(compAscStr, heap, getStringsArray(), true);
        sortAndPrintArray(compAscStr, bubble, getStringsArray(), true);

        System.out.println("\n");

        System.out.println("Using MiFactory:");
        // received as Object class
        Object s1 = MiFactory.getInstance("sorter");
        System.out.print("\t->\tCreated: " + s1.toString() + "\n");
        // casted to Sorter Class
        Sorter quickFactory = (Sorter) MiFactory.getInstance("quick");
        System.out.print("\t->\tCreated: " + quickFactory.toString() + "\n");

        Sorter heapFactory = (Sorter) MiFactory.getInstance("heap");
        System.out.print("\t->\tCreated: " + heapFactory.toString() + "\n");

        Sorter bubbleFactory = (Sorter) MiFactory.getInstance("bubble");
        System.out.print("\t->\tCreated: " + bubbleFactory.toString() + "\n");

        System.out.println("--------");

        sortAndPrintArray(compAscInt, quickFactory, getIntegersArray(), true);
        sortAndPrintArray(compAscInt, heapFactory, getIntegersArray(), true);
        sortAndPrintArray(compAscInt, bubbleFactory, getIntegersArray(), true);
        System.out.println("--------");
        sortAndPrintArray(compAscStr, quickFactory, getStringsArray(), true);
        sortAndPrintArray(compAscStr, heapFactory, getStringsArray(), true);
        sortAndPrintArray(compAscStr, bubbleFactory, getStringsArray(), true);

        System.out.println("--------");

        sortAndPrintArray(compAscInt, quickFactory, getRandomIntegersArray(100000), false);
        sortAndPrintArray(compAscInt, heapFactory, getRandomIntegersArray(100000), false);
        sortAndPrintArray(compAscInt, bubbleFactory, getRandomIntegersArray(100000), false);

    }

    private static <T> void sortAndPrintArray(Comparator<T> criteria, Sorter sorter, T[] arr, boolean mustPrint) {
        Time time = new Time();
        System.out.print(sorter.toString() + ":\t");
        if (mustPrint) printArr(arr);
        time.start();
        sorter.sort(arr, criteria);
        time.stop();
        if (mustPrint) printArr(arr);
        System.out.println("Array Size: " + arr.length + "\t->\tElapsed Time (ms): " + time.elapsedTime());
    }

    private static Integer[] getIntegersArray() {
        Integer arr[] = {8, 2, 1, 5, 7, 3, 4};
        return arr;
    }

    private static Integer[] getRandomIntegersArray(int cant) {
        Integer arr[] = new Integer[cant];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(cant);
        }
        return arr;
    }

    private static String[] getStringsArray() {
        String arr2[] = {"k", "a", "z", "n", "f", "b"};
        return arr2;
    }

    public static <T> void printArr(T[] arr) {
        for (T t : arr) {
//            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""))
            System.out.print(t.toString() + " ");
        }
        System.out.print("\t->\t");
    }
}
