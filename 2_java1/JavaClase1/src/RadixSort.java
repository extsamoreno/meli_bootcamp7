import java.util.ArrayList;
import java.util.Arrays;
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

        //create a HashMap with empty ArrayList
        for (int i = 0; i < 10; i++) {
            myHash.put(i, new ArrayList<>());
        }

        int maxLen = StringUtils.maxLength(StringUtils.toStringArray(arr));

        for (int i = maxLen-1; i >= 0; i--) {
            for (String str: strArray) {
                int k = str.charAt(i) - '0';

                myHash.get(k).add(str);
            }

            strArray = new String[arr.length];

            for (int k = 0; k < 10; k++) {
                int ind = 0;
                for (String numStr: myHash.get(k)) {
                    strArray[ind] = numStr;
                    ind++;
                }
                myHash.get(k).clear();
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

