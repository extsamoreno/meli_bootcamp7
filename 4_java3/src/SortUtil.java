public class SortUtil {
    public static <T> void ordenar (Precedable <T> arr[]) { // voy a recibir un generic
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].precedeA((T) arr[j+1]) > 0) // ordenando arreglos del tipo Precedable (no int)
                {
                    Precedable <T> temp = arr[j]; // temp tipo de dato generico de la interfaz
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}