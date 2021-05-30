package com.company;

import java.util.*;

public interface Sorter<T> {

    public abstract void sort(T arr[], Comparator<T> c);

}
