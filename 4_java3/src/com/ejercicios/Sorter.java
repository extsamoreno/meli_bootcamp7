package com.ejercicios;

import java.util.Comparator;

public interface Sorter <T>{
    public void sort(T arr[], Comparator<T> c);
}
