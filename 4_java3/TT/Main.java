import paquete.Sorter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        //Persona arr[] = new Persona[100000];

        Integer arr[] = {64, 34, 25, 12, 22, 11, 90};
        Comparator<Integer> c = (a,b)-> a-b;

        Sorter s = (Sorter) MiFactory.getInstance("sorter");

        s.sort(arr,c);

        printArray(arr);
    }

    private static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
