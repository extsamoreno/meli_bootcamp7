public class SortUtil {
    public static <T> void ordenar(Precedable<T>[] arr){
        for (int k = 1; k <= arr.length; k++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].precedeA((T) arr[i + 1]) > 0) {
                    Precedable<T> aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                }
            }
        }
    }

    public static <T> void ordenar2(Precedable<T>[] arr) {
        boolean flag = true;
        int k = 1;
        while(flag && k <= arr.length) {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].precedeA((T) arr[i + 1]) > 0) {
                    Precedable<T> aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    flag = true;
                }
                k++;
            }
        }
    }
}
