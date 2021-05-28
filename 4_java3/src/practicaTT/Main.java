package practicaTT;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Comparator<Integer> compAscInt = (a, b) -> b - a;
        Integer arr[] = {1, 2, 5, 7, 3, 4};

        Comparator<String> compAscStr = (a, b) -> b.compareTo(a);
        String arr2[] = {"a", "n", "f", "b"};

        System.out.println("Original");
        printArr(arr);
        System.out.println("QuickSort");
        new QuickSortSorterImple().sort(arr, compAscInt);
        printArr(arr);
        System.out.println("HeapSort");
        new HeapSortSorterImple().sort(arr, compAscInt);
        printArr(arr);
        System.out.println("BubbleSort");
        new BubbleSortSorterImple().sort(arr, compAscInt);
        printArr(arr);

        System.out.println("");

        System.out.println("Original");
        printArr(arr2);
        System.out.println("QuickSort");
        new QuickSortSorterImple().sort(arr2, compAscStr);
        printArr(arr2);
        System.out.println("HeapSort");
        new HeapSortSorterImple().sort(arr2, compAscStr);
        printArr(arr2);
        System.out.println("BubbleSort");
        new BubbleSortSorterImple().sort(arr2, compAscStr);
        printArr(arr2);
    }

    public static <T> void printArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].toString());
        }
        System.out.println("");
    }
}
