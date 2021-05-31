package ejtt;
import java.util.Comparator;

public class QuickSortSorterImple <T> implements Sorter<T> {
  @Override
  public void sort( T arr[], Comparator<T> c) {
    quicksort(arr, 0, arr.length, c);
  }

  private void quicksort (T arr[], int izq, int der, Comparator<T> c) {
    T pivote = arr[izq];
    int i = izq;
    int j = der;
    T aux;

    while (i < j) {
      while (c.compare(arr[i], pivote) < 0  && i < j) i++;
      while (c.compare(arr[j], pivote) > 0) j--;
      if (i < j) {
        aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
      }
    }

    arr[izq] = arr[j];
    arr[j] = pivote;

    if(izq < j-1)
      quicksort(arr, izq, j-1, c);
    if (j+1 < der)
      quicksort(arr, j+1, der, c);

  }
}

