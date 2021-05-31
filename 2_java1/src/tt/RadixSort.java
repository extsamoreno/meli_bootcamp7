package tt;

public class RadixSort {

    public static void radixSort(int[] arr) {

        String[] sArr = StringUtil.toStringArray(arr);

        StringUtil.lNormalize(sArr, '0');
        StringUtil.order(sArr);

        int[] intArr = StringUtil.toIntArray(sArr);
        System.arraycopy(intArr,0,arr, 0,arr.length);
    }

    public static void main(String[] args) {

        int[] arr = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}