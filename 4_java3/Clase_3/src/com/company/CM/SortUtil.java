package com.company.CM;

import java.sql.PreparedStatement;

public class SortUtil <T> {
    public static <T> void ordenar(Precedable<T>[] arr){
        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = 0 ; j < n-i-1 ; j++) {
                Precedable p = arr[j];
                Precedable t = arr[j+1];
                if(p.precedeA(t)>=1) { // seria el de (j+1).precede(j) ?
                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
}
