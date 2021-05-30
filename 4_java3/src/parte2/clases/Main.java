package src.parte2.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        Time t = new Time();

        Integer[] intArr = new Integer[100000];

        for (Integer i = 0; i < 100000; i++) {
            intArr[i] = 100000 - i;
        }

        for (int i = 0; i < 15; i++) {
            System.out.print(intArr[i] + " ");
        }

        System.out.println();
        t.start();

        //Sorter q = (Sorter) MiFactory.getInstance("sorter");
        //Sorter q = new BubbleSortSorterImple();

        //Comparator<Integer> c = (a,b)->a-b;
        Arrays.sort(intArr);

        //q.sort(intArr, (a,b)->a-b);

        t.stop();

        for (int i = 0; i < 15; i++) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println();
        System.out.println(t.getStartTime());
        System.out.println(t.getStopTime());

        System.out.println(t.elapsedTime());

        //32580ms Cuando usamos BubbleSort directamente
        //32264ms Cuando usamos BubbleSort a traves de MiFactory
        //QuickSort obtiene error StackOverflow
        //68ms Cuando usamos HeapSort a traves de MiFactory
        //5ms Cuando usamos Arrays.sort de la libreria de Java
    }
}
