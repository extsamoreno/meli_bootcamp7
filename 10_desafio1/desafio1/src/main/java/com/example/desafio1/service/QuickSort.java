package com.example.desafio1.service;

import com.example.desafio1.model.Precedeable;

import java.util.Comparator;

public class QuickSort<T> implements Sorter<T>{

    @Override
    public <T> void sort(Precedeable<T>[] arr, Comparator<T> c) {
        quickSort(arr, 0, arr.length-1, c);
    }

    public <T> void quickSort(Precedeable<T>[] arr, int begin, int end, Comparator<T> c) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, c);

            quickSort(arr, begin, partitionIndex-1, c);
            quickSort(arr, partitionIndex+1, end, c);
        }
    }

    private <T> int partition(Precedeable<T>[] arr, int begin, int end, Comparator<T> c) {
        Precedeable<T> pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (c.compare((T)arr[j], (T)pivot) < 0) {
            //if (arr[j].precedeA((T)pivot) > 1) {
                i++;

                Precedeable<T> swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Precedeable<T> swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}

