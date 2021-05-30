package practicaTT;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

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

        System.out.println("Implementacion directa de los SORTERS:");
        sortAndPrintArray(compAscInt, quick, getIntegersArray());
        sortAndPrintArray(compAscInt, heap, getIntegersArray());
        sortAndPrintArray(compAscInt, bubble, getIntegersArray());
        System.out.println("--------");
        sortAndPrintArray(compAscStr, quick, getStringsArray());
        sortAndPrintArray(compAscStr, heap, getStringsArray());
        sortAndPrintArray(compAscStr, bubble, getStringsArray());

        System.out.println("\n--------\n");


        System.out.println("Implementacion Usando MiFactory:");
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
        System.out.println("");
        sortAndPrintArray(compAscInt, quickFactory, getIntegersArray());
        sortAndPrintArray(compAscInt, heapFactory, getIntegersArray());
        sortAndPrintArray(compAscInt, bubbleFactory, getIntegersArray());
        System.out.println("--------");
        sortAndPrintArray(compAscStr, quickFactory, getStringsArray());
        sortAndPrintArray(compAscStr, heapFactory, getStringsArray());
        sortAndPrintArray(compAscStr, bubbleFactory, getStringsArray());

        System.out.println("\n--------\n");


    }

//    private static void sortAndPrintStringArray(Comparator<String> criteria, Sorter sorter) {
//        String[] arr = getStringsArray();
//        sortAndPrintArray(criteria, sorter, arr);
//    }
//
//    private static void sortAndPrintIntArray(Comparator<Integer> criteria, Sorter sorter) {
//        Integer[] arr = getIntegersArray();
//        sortAndPrintArray(criteria, sorter, arr);
//    }

    private static <T> void sortAndPrintArray(Comparator<T> criteria, Sorter sorter, T[] arr) {
        System.out.print(sorter.toString() + ":\t");
        printArr(arr);
        System.out.print("\t->\t");
        sorter.sort(arr, criteria);
        printArr(arr);
        System.out.println("");
    }

    private static Integer[] getIntegersArray() {
        Integer arr[] = {8, 2, 1, 5, 7, 3, 4};
        return arr;
    }

    private static String[] getStringsArray() {
        String arr2[] = {"k", "a", "z", "n", "f", "b"};
        return arr2;
    }

    public static <T> void printArr(T[] arr) {
        for (T t : arr) {
            System.out.print(t.toString());
        }
    }
}
