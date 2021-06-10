package com.example.desafio1.service.sortutil;

import java.util.Comparator;

public interface Sorter<T> {
    public <T> void sort(T[] arr, Comparator<T> comparator);
}
