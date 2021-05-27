import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
//import java.util.HashMap;

public class RadixSort {
    public static void radixSort(int []arr) {

        String resultado[];
        HashMap<String, ArrayList<String>> listas = new HashMap<>();

        resultado = StringUtil.toStringArray(arr);

        int max = StringUtil.maxLength(resultado);
        StringUtil.lNormalize(resultado, '0');
        for(int i =0 ; i< 10 ; i ++){
            listas.put("L"+i , new ArrayList<String>());
        }

        while(max >0) {
            for (int i = 0; i < arr.length; i++) {
                char aux = resultado[i].charAt(max);
                //listas.put();

            }
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