package practicaTM;

public class SortUtil {

    public static <T> void ordenar(Precedable<T> arr[]) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++)

            for (int j = 0; j < n - i - 1; j++)

                if (arr[j+1].precedeA((T)arr[j])>0) {
                    // swap arr[j+1] and arr[j]
                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }


    }
}
/*
int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
 */