package ejercicio1;

public class SortUtil{
    public static <T> ejercicio1.Precedable<T>[] ordenar(ejercicio1.Precedable<T>[] arr){
        //Bubble sort
        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = 0 ; j < n-i-1 ; j++) {
                ejercicio1.Precedable p = arr[j];
                ejercicio1.Precedable t = arr[j+1];
                if(t.precedeA(p) == 1) {
                    ejercicio1.Precedable<T> temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }
}