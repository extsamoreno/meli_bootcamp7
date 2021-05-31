package PracticoTarde;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T>{

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quicksort(arr,c,0, arr.length-1);
    }

    private void quicksort(T arreglo[], Comparator<T> c, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, c, izquierda, derecha);
            quicksort(arreglo, c, izquierda, indiceParticion);
            quicksort(arreglo, c, indiceParticion + 1, derecha);
        }
    }

    private <T> int particion(T arreglo[], Comparator<T> c, int izquierda, int derecha) {
        T pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            while (c.compare(arreglo[izquierda], pivote) < 0) {
                izquierda++;
            }
            while (c.compare(arreglo[derecha], pivote) > 0) {
                derecha--;
            }
            if (izquierda >= derecha) {
                return derecha;
            } else {//Nota: yo sé que el else no hace falta por el return de arriba, pero así el algoritmo es más claro
                T temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
                izquierda++;
                derecha--;
            }
            // El while se repite hasta que izquierda >= derecha
        }
    }


}
