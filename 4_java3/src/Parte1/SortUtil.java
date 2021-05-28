package Parte1;

public class SortUtil {

    public static <T> void ordenar (IPrecedable<T>[] arr) {

        for (int j = 0; j < arr.length -1; j++) {
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i].precedeA((T) arr[i+1]) > 0) {
                IPrecedable<T> menor = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = menor;
                }
            }
        }
    }

    public static <T> void ordenarString(IPrecedable<T>[] arr) {

        for (int j = 0; j < arr.length -1; j++) {
            for (int i = 0; i < arr.length -1; i++) {
                if (arr[i].precedeString((T) arr[i+1]) > 0) {
                    IPrecedable<T> menor = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = menor;
                }
            }
        }
    }
}



/*
* COMO TE EXTRAñO PYTHON :3
* */