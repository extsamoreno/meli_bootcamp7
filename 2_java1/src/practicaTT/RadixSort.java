package practicaTT;


import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort {

    public static void radixSort(int[] arr) {

        String[] listOfString = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(listOfString, '0');

        int digitIndex = StringUtil.maxLength(listOfString) - 1;

        while (digitIndex >= 0) {

            sortByDigitIndex(listOfString, digitIndex);

            digitIndex--;
        }

        arr = StringUtil.toIntArray(listOfString);

        System.out.println("\n\nDentro de radixSort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }

    }

    public static void sortByDigitIndex(String[] listOfString, int digitIndex) {
        int totalList = 10;
        HashMap<Integer, ArrayList<String>> mapOfList = createMapWithLists(totalList);

        for (String elem : listOfString) {
            int digit = Integer.parseInt(String.valueOf(elem.charAt(digitIndex)));

            mapOfList.get(digit).add(elem);
        }
        System.out.println("\n\nDigitIndex:\t" + digitIndex);
        updateListFromMap(listOfString, mapOfList, totalList);

        System.out.println("\nDentro de sortByDigitIndex");

        for (int i = 0; i < listOfString.length; i++) {
            System.out.print(listOfString[i] + (i < listOfString.length - 1 ? "," : ""));
        }

    }

    public static HashMap<Integer, ArrayList<String>> createMapWithLists(int n) {
        HashMap<Integer, ArrayList<String>> mapOfList = new HashMap<Integer, ArrayList<String>>();
        for (int i = 0; i < n; i++) {
            mapOfList.put(i, new ArrayList<String>());
        }
        return mapOfList;
    }

    private static void updateListFromMap(String[] listOfString, HashMap<Integer, ArrayList<String>> mapOfList, int totalList) {
        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < totalList; i++) {
            temp.addAll(mapOfList.get(i));
        }
        System.out.println("Dentro de updateList");
        listOfString = temp.toArray(new String[0]);
        for (int i = 0; i < listOfString.length; i++) {
            System.out.print(listOfString[i] + (i < listOfString.length - 1 ? "," : ""));
        }
    }

    public static void main(String[] args) {

        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};

        radixSort(arr);

        System.out.println("\n\nDentro de main");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }

    }
}
