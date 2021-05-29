package Parte2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        Integer arr[] = {1,2,5,2,29,6,5};
        showArr(arr);

        Sorter q = (Sorter) MiFactory.getInstance("sorterB");

        //QuickSortSorterImple q = new QuickSortSorterImple();
        //HeapSortSorterImple q = new HeapSortSorterImple();
        //BurbleSortSorterImple q = new BurbleSortSorterImple();

        System.out.println(" ");
        q.sort(arr, (a, b)->a-b);
        showArr(arr);
        System.out.println("\n----- . ---- . ----- . ---- . ----");

        String[] arr1 = {"Nicoll", "Alejandro", "Daniel", "David"};
        showArr(arr1);

        Sorter head = (Sorter) MiFactory.getInstance("sorterH");

        System.out.println(" ");
        q.sort(arr1, (a, b)->a.compareTo(b));
        showArr(arr1);*/ //Punto 10

        Integer[] intArr = new Integer[100000];
        Time t = new Time();

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = intArr.length - i;
        }
        showArr(intArr);

        //Sorter  q = (Sorter) MiFactory.getInstance("sorterH");

        t.start();
        //q.sort(intArr, (a, b)->a-b);

        Arrays.sort(intArr);
        t.stop();
        System.out.println(t.elapsedTime());
        showArr(intArr);
    }

    public static <T> void showArr(T[] arr){
        for (T t: arr) {
            System.out.print(t + " ");
        }
    }

    public static void showArr(Integer[] arr){
        for (int i = 0; i < 15; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    // 53440 BurberSort
    // 54880 BurberSort Usando Mifactory
    // 54880 QuickSort
    // 83 HeadSort
    // 9  Arrays.sort


    // Arrays.sort(numeros);
}
