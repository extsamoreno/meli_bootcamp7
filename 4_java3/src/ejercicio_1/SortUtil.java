package ejercicio_1;

public class SortUtil {
    public static <T> void ordenar(Precedable<T> arr[]) {
        int i, j;
        Precedable<T> aux;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1].precedeA((T) arr[j]) == 1) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }
    /*El método ordenar puede ordenar cualquier tipo de dato dado que maneja un tipo de dato general, es decir,
    asumirá el tipo de dato que le entregue la clase
     */
}
