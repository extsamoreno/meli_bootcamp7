public class SortUtils {
    public static <T> void ordenar(Precedable<T>[] arr)
    {
       // Bubble Sort
        int n = arr.length;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1].precedeA((T) arr[j]) == 1){
                    Precedable temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
