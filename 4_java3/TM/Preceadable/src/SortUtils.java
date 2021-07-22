public class SortUtils {
    public static <T> void order(Precedeable<T>[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].precedes((T)array[j + 1 ]) > 0) {
                    Precedeable<T> aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }
}
