package EjerciciosT;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Comparator<Integer> compAscInt = (a, b) -> b - a;
        Integer arr[] = {1, 2, 5, 7, 3, 4};

        new QuickSortSorterImple().sort(arr, compAscInt);
        printArr(arr);
    }

    public static <T> void printArr(T[] arr){

        System.out.println("\n");

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i].toString() + "\n");
        }
    }
}
