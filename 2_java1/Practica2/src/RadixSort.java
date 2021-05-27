import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {
    public static void radixSort(int []arr)
    {
        // Convertir el array que vamos a ordenar, de int[] a String[]
        //int newArr[] = new int[arr.length];
        String newArr[] = StringUtil.toStringArray(arr);

        // Normalizar el array
        StringUtil.lNormalize(newArr,'0');

        // Generar las 10 listas vacias dentro de un HashMap
        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
        for(int i=0; i<=9; i++){
            hm.put(i,new ArrayList<>());
        }

        // Creacion de un ArrayList temporal
        ArrayList<String> temporal = new ArrayList<>();

        for (int indice=StringUtil.maxLength(newArr) -1; indice>=0; indice--){
            // Leer el digito y agregarlo a su lista correspondiente
            for (String casilla : newArr){
                int digito = Integer.parseInt(String.valueOf(casilla.charAt(indice)));
                hm.get(digito).add(casilla);
            }

            // Recorrer las listas en el map y reconstruir el temporal
            for (Map.Entry<Integer, ArrayList<String>> entry: hm.entrySet()){
                for (String x : entry.getValue()){
                    temporal.add(x);
                }

                // Limpiar las listas en el map
                entry.getValue().clear();
            }

            // Actualizar newArray
            for (int i=0; i< newArr.length; i++){
                newArr[i] = temporal.get(i);
            }

            // Limpiar temporal
            temporal.clear();
        }

        // Convertir el array ordenado, de String[] a int[]
        int newArr2[] = StringUtil.toIntArray(newArr);

        // Actualizar el array de entrada
        for(int i=0; i< arr.length; i++){
            arr[i] = newArr2[i];
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
