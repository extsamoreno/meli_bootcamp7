import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RadixSort {

    public static void radixSort(int []arr){

        String[] strarr = intToStringArray(arr);
        int max = getMaximumLengthElement(strarr);
        rellenarConCeros(max,strarr);
        HashMap<Integer,ArrayList<String>> map = crearMapListas(strarr);

        for(int i=1;i<=max;i++){
            rellenarListas(strarr,map,i);
            rellenarStringArray(strarr,map);
        }

        for(int i=0;i<strarr.length;i++){
            System.out.println(strarr[i]);
        }

    }

    private static void rellenarListas(String[] strarr, HashMap<Integer,ArrayList<String>> map, int cant){
        //int ult;
        int len = strarr.length;
        String ult;
        List<String> list = new ArrayList<String>(Arrays.asList(strarr));
        for(String s : strarr){
            //ult = Integer.parseInt(s)%(10);
            ult = s.substring(s.length()-cant,s.length()-cant+1);
            map.get(Integer.parseInt(ult)).add(s);
            //map.get(ult).add(s);
            list.remove(s);
        }
        strarr = list.toArray(new String[len]);
    }

    private static void rellenarStringArray(String[] strarr, HashMap<Integer,ArrayList<String>> map){
        int i=0;
        int len = strarr.length;
        List<String> list = new ArrayList<String>();
        for(int key : map.keySet()){
            for(String value : map.get(key)){
                list.add(value);
            }

            i++;
        }
        int k = 0;
        for(String s : list){
            if(k< strarr.length){

                strarr[k] = s;
                k++;
            }
        }
        list.clear();
        for(int key : map.keySet()){
           map.get(key).clear();

            }
    }
    private static HashMap<Integer, ArrayList<String>> crearMapListas(String[] strarr) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        for (int i = 0; i <= 9; i++) {
            map.put(i, new ArrayList<String>());
        }
        return map;
    }


    public static String[] intToStringArray(int []arr){
        String[] strarr = new String[arr.length];
        for (int i=0; i<arr.length; i++){
            strarr[i] = String.valueOf(arr[i]);
        }
        return strarr;
    }
    public static int getMaximumLengthElement(String[] strarr){
        int max = 0;
        for (String s : strarr){
            if(s.length()>max)
                max=s.length();
        }
        return max;
    }

    public static void rellenarConCeros(int max, String[] strarr)
    {   String aux;
        for(int i = 0; i<strarr.length;i++){
            int cantCeros = max - strarr[i].length();

            if(cantCeros>0)
            {
                aux="";
                for(int j=0;j<cantCeros;j++){
                    aux+=0;
                }
                aux+=strarr[i];
                strarr[i] = aux;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1234,1,22322,999999,123,12,5,6};

        radixSort(arr);


    }
}
