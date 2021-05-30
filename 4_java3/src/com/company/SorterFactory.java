package com.company;

public class SorterFactory<T> {
    public static <T> Sorter<T> getSorter(String sorter) {
        if (sorter.toUpperCase().equals("BUBBLE")) {
            return new BubbleSortSorterImple<>();
        }
        if (sorter.toUpperCase().equals("QUICK")) {
            return new QuickSortSorterImple<>();
        }
        if (sorter.toUpperCase().equals("HEAP")) {
            return new HeapSortSorterImple<>();
        }
        return null;
    }
}
