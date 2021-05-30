package ejercicios;

import java.util.Comparator;

public class main2 {
    public static void main(String[] args) {
        Integer arr[]={12,34,4,1,2,3,18};
        Comparator<Integer> c= (c1,c2)->(c1-c2);
        Sorter Ordenar = new BubbleSortSorterImple();
        Ordenar.sort(arr,c);

        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
