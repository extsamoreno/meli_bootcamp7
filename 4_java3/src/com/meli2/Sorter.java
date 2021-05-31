package com.meli2;

import java.util.Comparator;

public interface Sorter <T>{
    public void sort(T[] arr, Comparator<T> c);
}
