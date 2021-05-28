package Ex1;

public class SortUtil {
    public static <T> void ordenar(Precedable<T> arr[]){
        int i, j;
        int n = arr.length;
        for (i = 0; i < n-1; i++)
            for (j = 0; j < n-i-1; j++)
                if (arr[j].precedeA((T)arr[j+1]) == 1) {
                    var aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j=1] = aux;
                }
    }
}
