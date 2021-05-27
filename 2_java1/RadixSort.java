public class RadixSort {

    public static void radixSort(int []arr){
        String[] stringArr = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(stringArr,'0');
        System.out.println(stringArr);

    }


    public static void main(String[] args) {

    }
}
