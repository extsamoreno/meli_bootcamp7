import java.util.Comparator;

public class HeapSortSorterImple implements Sorter<HeapSortSorterImple>{

    @Override
    public void sort(HeapSortSorterImple[] arr, Comparator<HeapSortSorterImple> c) {
        final int N = arr.length;
        for(int nodo = N/2; nodo>=0; nodo--) hacerMonticulo(arr, nodo, N-1,c);
        for(int nodo = N-1; nodo>=0; nodo--) {
            HeapSortSorterImple tmp = arr[0];
            arr[0]    = arr[nodo];
            arr[nodo] = tmp;
            hacerMonticulo(arr, 0, nodo-1,c);
        }

    }

    private static void hacerMonticulo(HeapSortSorterImple[] arr, int nodo, int fin, Comparator<HeapSortSorterImple> c) {
        int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may=  c.compare(arr[izq],arr[der]) ==1 ?izq:der;
        if( c.compare(arr[nodo],arr[may]) == -1) {
            HeapSortSorterImple tmp = arr[nodo];
            arr[nodo] = arr[may];
            arr[may]  = tmp;
            hacerMonticulo(arr, may, fin,c);
        }
    }

}
