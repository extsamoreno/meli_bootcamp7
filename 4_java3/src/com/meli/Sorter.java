package com.meli;

import java.util.Comparator;

public interface Sorter<T> {
    public abstract void sort(T arr[], Comparator<T> c);
}
