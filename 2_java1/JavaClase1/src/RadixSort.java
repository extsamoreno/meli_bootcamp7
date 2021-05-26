import java.util.ArrayList;
import java.util.HashMap;
import functions.StringUtils;

public class RadixSort
{
    public static void radixSort(int[] arr)
    {
        //Implementación
        String[] strArray = StringUtils.toStringArray(arr);
        StringUtils.lNormalize(strArray, '0');
        HashMap<Integer, ArrayList<String>> myHash = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            myHash.put(i, new ArrayList<>());
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

