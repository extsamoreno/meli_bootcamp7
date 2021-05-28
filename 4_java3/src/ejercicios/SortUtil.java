package ejercicios;
//
public class SortUtil {
    public static <T> void ordenar( Precedable<T> arr[]) {
        int n = arr.length;
        Precedable<T> temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j - 1].precedeA((T) arr[j])==1){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
