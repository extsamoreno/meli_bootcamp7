package Practice;

import java.util.ArrayList;

public class Utils {
    public static <T> void printArrayList(ArrayList<T> arr) {
        for (T p : arr) {
            System.out.println("\t\t" + p);
        }
    }
}
