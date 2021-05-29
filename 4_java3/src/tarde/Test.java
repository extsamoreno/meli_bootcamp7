package tarde;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Integer iArr[] = {1,9,7,3,2,8};
        String sArr[] = {"A", "Z", "B", "X", "C", "Y"};

        Integer arrBig[] = new Integer[1000];

        Integer aux= 999;
        for (int i = 0; i < 1000; i++)
            arrBig[i] = aux--;

        //BubbleSort
        /*BubbleSortSorterImple<String> bubble = new BubbleSortSorterImple<>();
        bubble.sort(sArr, (a,b) -> a.compareTo(b));
        System.out.print("BubbleSort: ");
        printArray(sArr, sArr.length );

        //QuickSort
        QuickSortSorterImple<Integer> quick = new QuickSortSorterImple<>();
        quick.sort(iArr, (a,b) -> a-b);
        System.out.print("\nQuickSort: ");
        printArray(iArr, iArr.length);

        //HeapSort
        HeapSortSorterImple<String> heap = new HeapSortSorterImple<>();
        heap.sort(sArr, (a,b) -> a.compareTo(b));
        System.out.print("\nHeapSort: ");
        printArray(sArr, sArr.length);*/


        //region ordeno vector string
        Object sorter2 = MiFactory.getInstance("sorter");
        Class cls2 = sorter2.getClass();
        Method meth2 = null;
        try {
            meth2 = cls2.getDeclaredMethod("sort",  Object[].class, Comparator.class);

            Comparator<String> comp = (a,b) -> a.compareTo(b);
            meth2.setAccessible(true);
            meth2.invoke(sorter2, sArr, comp);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        printArray(sArr, sArr.length);
        //endregion


        System.out.println();
        printArray(arrBig, arrBig.length);
        System.out.println();

        Time time = new Time();
        time.start();

        Object sorter3 = MiFactory.getInstance("sorter");

        Class cls3 = sorter3.getClass();
        Method meth3 = null;
        try {
            meth3 = cls3.getDeclaredMethod("sort",  Object[].class, Comparator.class);

            Comparator<Integer> c3 = (a,b) -> a-b;
            meth3.setAccessible(true);
            meth3.invoke(sorter3, arrBig, c3);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        time.stop();

        printArray(arrBig, arrBig.length);
        System.out.println("\nTime:" + time.elapsedTime());

        //test with 1000 elements
        //bubble - 14 millis
        //quick - 10 millis
        //heap - 2 millis :o











    }

    static <T> void printArray(T arr[], int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] +" ");

    }

}
