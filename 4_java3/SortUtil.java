public class SortUtil {

    public static <T> void ordenar(Precedable<T> arr[]){
        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = 0 ; j < n-i-1 ; j++) {
                Precedable p = arr[j];
                Precedable t = arr[j+1];
                if(p.precedeAt(t)>0) {
                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
