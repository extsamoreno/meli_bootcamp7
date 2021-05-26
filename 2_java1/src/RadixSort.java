import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        StringUtil stringUtil = new StringUtil();
        String[] str = stringUtil.toStringArray(arr);
        int lon = stringUtil.maxLength(str);
        for (int i = 0; i < arr.length; i++) {
            str[i] = stringUtil.lpad(str[i], lon, '0');
        }

        for (int i = 0; i < lon; i++) {
            List<String> L0 = new ArrayList<>();
            List<String> L1 = new ArrayList<>();
            List<String> L2 = new ArrayList<>();
            List<String> L3 = new ArrayList<>();
            List<String> L4 = new ArrayList<>();
            List<String> L5 = new ArrayList<>();
            List<String> L6 = new ArrayList<>();
            List<String> L7 = new ArrayList<>();
            List<String> L8 = new ArrayList<>();
            List<String> L9 = new ArrayList<>();
            for (int j = 0; j < str.length; j++) {
                switch ((str[j].charAt((str[j].length() - 1) - i))) {
                    case '0':
                        L0.add(str[j]);
                        break;
                    case '1':
                        L1.add(str[j]);
                        break;
                    case '2':
                        L2.add(str[j]);
                        break;
                    case '3':
                        L3.add(str[j]);
                        break;
                    case '4':
                        L4.add(str[j]);
                        break;
                    case '5':
                        L5.add(str[j]);
                        break;
                    case '6':
                        L6.add(str[j]);
                        break;
                    case '7':
                        L7.add(str[j]);
                        break;
                    case '8':
                        L8.add(str[j]);
                        break;
                    case '9':
                        L9.add(str[j]);
                        break;
                }
            }
            List<String> temp = new ArrayList<>();
            temp.addAll(L0);temp.addAll(L1);temp.addAll(L2);temp.addAll(L3);temp.addAll(L4);
            temp.addAll(L5);temp.addAll(L6);temp.addAll(L7);temp.addAll(L8);temp.addAll(L9);
            str = temp.toArray(str);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(str[i]);
        }
    }
}
