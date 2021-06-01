package ejercicio1;


import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static <T> void printArr(List<T> arr) {
        for (T t : arr) {
            System.out.print(t.toString() + " ");
        }
        System.out.println(" ");
    }

    public static <T> List<T> listof(T arr[]) {
        List<T> lista = new ArrayList<>();
        for (T elem : arr) {
            lista.add(elem);
        }
        return lista;

    }
}