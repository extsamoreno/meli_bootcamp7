package Exercise1;

public class SortUtil {
    public static <T> void ordenar(Precedable<T> arr[]){
        for(int k=1;k<arr.length-1;k++){
            for (int i = 0; i < arr.length - k; i++) {
                if (arr[i].precedeA((T) arr[i + 1]) > 0) {
                    Precedable<T> menor = arr[i+1];
                    arr[i + 1] = arr[i];
                    arr[i] = menor;
                }
            }
        }
    }
}