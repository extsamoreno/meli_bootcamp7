import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Sorter s =  (QuickSortSorterImple) MiFactory.getInstance("sorter");

        Integer[] iArr = {5,3,0,2,6,9,2};
        mostrarArr(iArr);
        Comparator<Integer> c1 = (a, b) -> a-b;
        s.sort(iArr,c1);
        mostrarArr(iArr);

//        String[] sArr = {"z", "l", "q", "a", "m"};
//        Comparator<String> c2 = (s1,s2) -> s1.compareTo(s2);
//        mostrarArr(sArr);
//
//        mostrarArr(sArr);
    }

    public static <T> void mostrarArr(T[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
