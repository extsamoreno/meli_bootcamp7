package bootcamp;

import java.util.Comparator;

public class QuickSortSorterImple <T> implements Sorter<T>{

        public static <T> void quicksort(T A[], Comparator<T> c, int izq, int der) {

            System.out.println("Ordenando con Quick Sort");

            T pivote = A[izq];  // tomamos indice de primer elemento como pivote
            int i=izq;         // i realiza la búsqueda de izquierda a derecha
            int j=der;         // j realiza la búsqueda de derecha a izquierda
            T aux;

            while(i < j){                          // mientras no se crucen las búsquedas
                while((int) c.compare(A[i], pivote) <=0 && i < j) i++; // busca elemento mayor que pivote
                while((int) c.compare(A[j], pivote) >0.0 ) j--;           // busca elemento menor que pivote
                if (i < j) {                        // si no se han cruzado
                    aux= A[i];                      // los intercambia
                    A[i]=A[j];
                    A[j]=aux;
                }
            }

            A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
            A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

            if(izq < j-1)
                quicksort(A, c,izq,j-1);          // ordenamos subarray izquierdo
            if(j+1 < der)
                quicksort(A,c, j+1,der);          // ordenamos subarray derecho

        }

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quicksort(arr, c, 0, arr.length-1);
    }
}