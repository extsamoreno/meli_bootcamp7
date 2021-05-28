package com.meli;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	    Integer[] arr = new Integer[]{9,8,6,7,5,4,3,2,1,0};
        Comparator<Integer> comp = (n1,n2)->n1-n2;
        //QuickSorterImple<Integer> sorter = new QuickSorterImple<>();
        //HeapSorterImple<Integer> sorter = new HeapSorterImple<>();
        BubbleSorterImple<Integer> sorter = new BubbleSorterImple<>();
        sorter.sort(arr,comp);
        for(Integer x : arr ){ System.out.print(x+"-");}
    }
}
