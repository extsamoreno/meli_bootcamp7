import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Integer arr[] = createIntArray(100000);
        Sorter<Integer> sorter =  (Sorter) MiFactory.getInstance("sorter");



        mostrarArr(arr);
        Comparator<Integer> c1 = (a, b) -> a-b;


        Time t = new Time();
        t.start();
        sorter.sort(arr,c1);
        t.stop();
        mostrarArr(arr);
        System.out.println(t.elapsedTime());
    }

    public static <T> void mostrarArr(T[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    private static Integer[] createIntArray(int n)
    {
        Integer arr[] = new Integer[n];
        for(int i=n-1;i>=0; i--)
        {
            arr[n-i-1]=i;
        }
        return arr;
    }
}
