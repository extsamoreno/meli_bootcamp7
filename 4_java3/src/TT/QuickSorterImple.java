package TT;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSorterImple <T> implements Sorter<T>{
    @Override
    public void Sort(T arr[], Comparator<T> c){
        quicksort(arr,0,arr.length, c);
    }

    //Son dos tipos genericos los que estoy comparando
    private static <T> void quicksort(T A[], int izq, int der, Comparator<T> c) {
        T pivote = A[0]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas

          c.compare(a -> A[])

            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(A,j+1,der);          // ordenamos subarray derecho
    }

}
