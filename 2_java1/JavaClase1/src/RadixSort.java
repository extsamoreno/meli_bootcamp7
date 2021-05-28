import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import functions.StringUtils;


public class RadixSort
{
    public static void radixSort(int[] arr)
    {
        //Implementación
        for (int i = StringUtils.maxIntLength(arr)-1; i >0; i--) {
            int[] nArr = StringUtils.myRadixSort(arr, i);
            for (int j = 0; j < nArr.length; j++) {
                arr[j] = nArr[j];
            }
        }


    }

    public static void main(String[] args)
    {
        int[] arr={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}

