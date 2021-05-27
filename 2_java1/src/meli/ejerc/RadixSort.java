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

    public static void radixSort(int []arr)
    {
        for (int i = 0; i < 9; i++) {
            //myHash.put(i, new ArrayList<String>());
        }

        String strArr[] = StringUtil.toStringArray(arr);

        StringUtil.lNormalize(strArr,'0');

        for(int i=0;i<StringUtil.maxLength(strArr);i++){
            for (String s : strArr) {
                switch (s.substring(s.length()-(i+1),s.length()-i)){
                    case "0":
                        L0.add(s);
                        break;
                    case "1":
                        L1.add(s);
                        break;
                    case "2":
                        L2.add(s);
                        break;
                    case "3":
                        L3.add(s);
                        break;
                    case "4":
                        L4.add(s);
                        break;
                    case "5":
                        L5.add(s);
                        break;
                    case "6":
                        L6.add(s);
                        break;
                    case "7":
                        L7.add(s);
                        break;
                    case "8":
                        L8.add(s);
                        break;
                    case "9":
                        L9.add(s);
                        break;
                }
            }

            ArrayList<String> sortedArr = new ArrayList<>();
            mergeLists(sortedArr);

        }
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
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}
