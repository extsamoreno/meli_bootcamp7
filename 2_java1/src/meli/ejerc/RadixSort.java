package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
    static ArrayList<String> L0 = new ArrayList<>();
    static ArrayList<String> L1 = new ArrayList<>();
    static ArrayList<String> L2 = new ArrayList<>();
    static ArrayList<String> L3 = new ArrayList<>();
    static ArrayList<String> L4 = new ArrayList<>();
    static ArrayList<String> L5 = new ArrayList<>();
    static ArrayList<String> L6 = new ArrayList<>();
    static ArrayList<String> L7 = new ArrayList<>();
    static ArrayList<String> L8 = new ArrayList<>();
    static ArrayList<String> L9 = new ArrayList<>();

    private static void distributeArray(String[] strArr, int idx){
        for (String s : strArr) {
            switch (s.charAt(s.length()-1-idx)){
                case '0':
                    L0.add(s);
                    break;
                case '1':
                    L1.add(s);
                    break;
                case '2':
                    L2.add(s);
                    break;
                case '3':
                    L3.add(s);
                    break;
                case '4':
                    L4.add(s);
                    break;
                case '5':
                    L5.add(s);
                    break;
                case '6':
                    L6.add(s);
                    break;
                case '7':
                    L7.add(s);
                    break;
                case '8':
                    L8.add(s);
                    break;
                case '9':
                    L9.add(s);
                    break;
            }
        }
    }

    public static void radixSort(int []arr)
    {
        HashMap myHash = new HashMap();
        for (int i = 0; i < 9; i++) {
            myHash.put(i, new ArrayList<String>());
        }

        String[] strArr = StringUtil.toStringArray(arr);

        StringUtil.lNormalize(strArr,'0');
        ArrayList<String> sortedArr;

        for(int i=0;i<StringUtil.maxLength(strArr);i++){
            clearLists();
            sortedArr = new ArrayList<>();
            distributeArray(strArr,i);
            mergeLists(sortedArr);


            for(int idx=0;idx<strArr.length;idx++){
                strArr[idx] = sortedArr.get(idx);
            }
        }

        for(int j=0;j<arr.length;j++){
            arr[j] = Integer.parseInt(strArr[j]);
        }
    }
    private static void clearLists(){
        L0.clear();
        L1.clear();
        L2.clear();
        L3.clear();
        L4.clear();
        L5.clear();
        L6.clear();
        L7.clear();
        L8.clear();
        L9.clear();
    }
    private static void mergeLists(ArrayList<String> arr){
        mergeList(L0,arr);
        mergeList(L1,arr);
        mergeList(L2,arr);
        mergeList(L3,arr);
        mergeList(L4,arr);
        mergeList(L5,arr);
        mergeList(L6,arr);
        mergeList(L7,arr);
        mergeList(L8,arr);
        mergeList(L9,arr);
    }
    private static void mergeList(ArrayList<String> fromList, ArrayList<String> toList){
        for (String s : fromList) {
            toList.add(s);
        }
    }

    public static void main(String[] args)
    {
        int arr[]={16223,999999999,898,13,906,235,23,9,1532,6388,2511,8,9999999};

        radixSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
