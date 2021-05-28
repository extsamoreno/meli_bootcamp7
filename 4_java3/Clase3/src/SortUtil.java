public class SortUtil {

    public static <T> void ordenar(Precedable<T> arr[]){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[j-1].precedeA((T) arr[j]) == 0){
                    swap(arr, j-1, j);
                }
            }
        }
        

        
    }


    private static <T> void swap(Precedable<T> arr[], int index1, int index2){


        Precedable<T> aux;

        aux = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = aux;

    }

    
}
