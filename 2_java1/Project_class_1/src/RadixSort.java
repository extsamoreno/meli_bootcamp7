import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
    public static void radixSort(int []arr)
    {
        int dur = 2;
        int repet = 1;
        while (repet!=dur) {
            //Adaptación del array
            String arr_str[] = StringUtil.toStringArray(arr);
            dur = StringUtil.maxLength(arr_str);
            StringUtil.lNormalize(arr_str, '0');

            //Creación de listas
            HashMap<Integer, ArrayList<String>> listas = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                listas.put(i, new ArrayList<>());
            }
            int tamArrStr = arr_str.length;



            //Llenado de listas
            for (int i = 0; i < tamArrStr; i++) {
                int valor = Character.getNumericValue(arr_str[i].charAt(arr_str[i].length() - repet));
                listas.get(valor).add(arr_str[i]);

            }
            ArrayList<String> ag_array = new ArrayList<>();
            for (int i = 0; i < listas.size(); i++) {
                ag_array.addAll(listas.get(i));
            }
            String[] ag_arrayst = new String[ag_array.size()];
            ag_arrayst = ag_array.toArray(ag_arrayst);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(ag_arrayst[i]);
            }


            repet++;

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
