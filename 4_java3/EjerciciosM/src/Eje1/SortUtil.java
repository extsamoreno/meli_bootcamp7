package Eje1;

public class SortUtil {
    public static <T> void ordenar(Precedable<T> arr[], int ord){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].precedeA((T)arr[j+1]) == ord){
                    var c = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = c;
                }
            }
        }
    }
}
