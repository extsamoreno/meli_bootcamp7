package PracticoTarde;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] iArr = {2,4,7,98,678,234};

        QuickSortSorterImple<Integer> qsi = new QuickSortSorterImple<>();
        HeapSort hs = new HeapSort();
        BubbleSortSortedImple bsi = new BubbleSortSortedImple();

        for(Integer item : iArr){
            System.out.print(item + " - ");
        }

        /*
        qsi.sort(iArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });


        hs.sort(iArr,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        bsi.sort(iArr,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        */

        System.out.println("");
        for(Integer item : iArr){
            System.out.print(item + " - ");
        }
    }
}
