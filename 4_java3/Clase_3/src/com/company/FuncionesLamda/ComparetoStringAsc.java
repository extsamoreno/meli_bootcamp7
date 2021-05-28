package com.company.FuncionesLamda;

import java.util.Comparator;

public class ComparetoStringAsc implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
