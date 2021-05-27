package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exercise6 {

    public static void preRadixSort(String[] sArr, int n) {
        HashMap<Integer, ArrayList<String>> hmL = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hmL.put(i, new ArrayList<>());
        }
        for (int i = 0; i < sArr.length; i++) {

            int it = Character.getNumericValue(sArr[i].charAt(n));
            hmL.get(it).add(sArr[i]);
        }

        int iter = 0;
        for (Map.Entry<Integer, ArrayList<String>> entry : hmL.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                sArr[iter] = entry.getValue().get(i);
                iter++;
            }
        }
        for (int i = 0; i < 10; i++) {
            hmL.get(i).clear();
        }
    }

    public static void radixSort(int[] arr) {
        String[] sArr = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(sArr, '0');

        int max = sArr[0].length();

        for (int i = max - 1; i >= 0; i--) {
            preRadixSort(sArr, i);
        }
        
        int[] iArr = StringUtil.toIntArray(sArr);
        for (int i = 0; i < iArr.length; i++) {
            arr[i] = iArr[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}
