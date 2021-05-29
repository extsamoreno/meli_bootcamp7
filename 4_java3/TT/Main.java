import paquete.Sorter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Integer[] arr = new Integer[100000];

        Comparator<Integer> c = (a, b)-> a-b;
        Sorter s = (Sorter) MiFactory.getInstance("sorter");

        for (int x=0;x<arr.length;x++)
            arr[x] = (int) (Math.random()*100000);

        s.sort(arr,c);

        printArray(arr);
    }

    private static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
    }
}
