package Elercicio2Tarde;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T>
{
    @Override
    public void ordenar(T[] arr, Comparator<T> c)
    {
        for(int i=0; i<arr.length;i++)
        {
            for(int j=0;j<arr.length-1;j++)
            {
                if( c.compare(arr[j],arr[j+1])>0 )
                {
                    T aux = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=aux;
                }
            }
        }
    }
}
