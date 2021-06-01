import java.util.Comparator;

public class QuickSortSorterImple implements Sorter<QuickSortSorterImple>{


    @Override
    public void sort(QuickSortSorterImple[] arr, Comparator<QuickSortSorterImple> c) {
        int izq = 0;
        int der = arr.length-1;
        quickSort(arr,izq,der,c);
    }

    private void quickSort(QuickSortSorterImple[] arr, int izq, int der, Comparator<QuickSortSorterImple> c){
        QuickSortSorterImple pivote=arr[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        QuickSortSorterImple aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while( c.compare(arr[i],pivote) == -1  && i < j) i++; // busca elemento mayor que pivote
            while( c.compare(arr[j],pivote) == 1) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= arr[i];                      // los intercambia
                arr[i]=arr[j];
                arr[j]=aux;
            }
        }

        arr[izq]=arr[j];      // se coloca el pivote en su lugar de forma que tendremos
        arr[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quickSort(arr,izq,j-1,c);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quickSort(arr,j+1,der,c);          // ordenamos subarray derecho
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[5];
        arr[0] = 65;
        arr[1] = 432;
        arr[2] = 5;
        arr[3] = 78;
        arr[4] = 175;

        QuickSortSorterImple prueba = new QuickSortSorterImple();
        Comparator<Integer> c1 = (a,b) ->  b-a;
        //prueba.sort(arr,c1);
    }
}
