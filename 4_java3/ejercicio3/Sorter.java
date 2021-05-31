package ejercicio3;

import java.util.Comparator;

public interface Sorter<T> {
    public void ordenar(T[] arr,Comparator<T> c);
}