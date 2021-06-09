package com.meli.SocialMeli.util;

import java.util.ArrayList;
import java.util.Comparator;

public class SortUtil<T> {
    public ArrayList<T> sort(ArrayList<T> list,Comparator<T> c) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (c.compare(list.get(j),list.get(j+1))>0) {
                    T tmp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,tmp);
                }
            }
        }
        return list;
    }
}
