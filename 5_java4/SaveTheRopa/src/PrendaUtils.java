import java.util.ArrayList;

public class PrendaUtils {
    public static <T> void printArrayList(ArrayList<T> arr) {
        for (T p : arr) {
            System.out.println("\t\t" + p);
        }
    }
}
