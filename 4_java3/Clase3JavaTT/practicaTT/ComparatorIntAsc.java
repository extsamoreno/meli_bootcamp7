package com.company.Clase3JavaTT.practicaTT;

import java.util.Comparator;

public class ComparatorIntAsc implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
