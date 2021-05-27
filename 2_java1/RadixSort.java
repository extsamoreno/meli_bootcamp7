import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort {

    public static void radixSort(int []arr){
        String[] stringArr = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(stringArr,'0');

        HashMap<Integer,ArrayList<String>> mapa = crearMap();

    }

    public static void agregarAlista(String[] arr,HashMap<Integer,ArrayList<String>> mapa){
        for (int i = 0; i < arr.length +1; i++) {
            mapa.get(i).add(

            );
        }
    }


    public static HashMap crearMap(){
        HashMap<Integer,ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
        for (int i = 0; i < 10; i++) {
            map.put(i,new ArrayList<String>());
        }
        return map;
    }


    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }     
    }
}
