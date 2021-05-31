package meli.ejerc;

public class SortUtil{
    public static <T> void ordenar(Precedable<T>[] arr){
        //Bubble sort
        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = 0 ; j < n-i-1 ; j++) {
                Precedable<T> p = arr[j];
                Precedable<T> t = arr[j+1];
                if(t.precedeA((T) p) == 1) {
                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
