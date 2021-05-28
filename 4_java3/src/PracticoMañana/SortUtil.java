package PracticoMañana;

public class SortUtil {

    public static <T> void ordenar(Precedable<T> arr[]){
        int size = arr.length;

        for (int i = 0; i < size - 1; i++){

            for (int j = 0; j < size - i - 1; j++){

                if (arr[j].precedeA((T) arr[j + 1]) > 0) {

                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


    }
}
