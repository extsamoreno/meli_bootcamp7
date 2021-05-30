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
        System.out.println("QuickSort:");
        sortAndPrintIntArray(compAscInt, quick);
        sortAndPrintStringArray(compAscStr, quick);
        System.out.println("HeapSort:");
        sortAndPrintIntArray(compAscInt, heap);
        sortAndPrintStringArray(compAscStr, heap);
        System.out.println("BubbleSort:");
        sortAndPrintIntArray(compAscInt, bubble);
        sortAndPrintStringArray(compAscStr, bubble);

        System.out.println("\n--------\n");


        System.out.println("Implementacion Usando MiFactory:");
        // received as Object class
        Object s1 = MiFactory.getInstance("sorter");
        System.out.print("\t->\tCreated: " + s1.getClass() + "\n");
        // casted to Sorter Class
        Sorter s2 = (Sorter) MiFactory.getInstance("sorter");
        System.out.print("\t->\tCreated: " + s2.getClass() + "\n");
        System.out.println("QuickSort:");
        sortAndPrintIntArray(compAscInt, s2);
        sortAndPrintStringArray(compAscStr, s2);
//        System.out.println("HeapSort:");
//        sortAndPrintIntArray(compAscInt, heap);
//        sortAndPrintStringArray(compAscStr, heap);
//        System.out.println("BubbleSort:");
//        sortAndPrintIntArray(compAscInt, bubble);
//        sortAndPrintStringArray(compAscStr, bubble);


    }

    private static void sortAndPrintStringArray(Comparator<String> criteria, Sorter sorter) {
        String[] arr = getStringsArray();
        sortAndPrintArray(criteria, sorter, arr);
    }

    private static void sortAndPrintIntArray(Comparator<Integer> criteria, Sorter sorter) {
        Integer[] arr = getIntegersArray();
        sortAndPrintArray(criteria, sorter, arr);
    }

    private static <T> void sortAndPrintArray(Comparator<T> criteria, Sorter sorter, T[] arr) {
        System.out.print("\t->\t");
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
