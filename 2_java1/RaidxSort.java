import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class RadixSort
{
    public static void radixSort(int []arr)
    {
        // convertir el array de int a string
        String[] stringArray = StringUtil.toStringArray(arr);

        // Todos los elementos con la misma longitud
        StringUtil.lNormalize(stringArray,'0');

        // Creamos las listas
        HashMap<Integer,ArrayList<String>> maps = new HashMap<>();
        for(int i = 0; i < stringArray.length; i++)
        {
            maps.put(i, new ArrayList<>());
        }

        // recorrer arreglo
        for(int j = stringArray[0].length() - 1; j >= 0; j--)
        {
            for (String s : stringArray)
            {
                int key = Integer.parseInt(String.valueOf(s.charAt(j)));
                maps.get(key).add(s);
            }

            int index = 0;

            for(Map.Entry<Integer,ArrayList<String>> entry : maps.entrySet())
            {
                for(String s : entry.getValue())
                {
                    stringArray[index] = s;
                    index++;
                }
                entry.getValue().clear();
            }
        }

        int[] intArray = StringUtil.toIntArray(stringArray);
        System.arraycopy(intArray, 0, arr, 0, intArray.length);
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
