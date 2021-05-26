import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {

    public static void radixSort(int[] arr) {
        //normalizamos el array
        String stringArr[] = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(stringArr, '0');

        //generamos un arrayList para manejar mas facil
        ArrayList<String> newArr = new ArrayList<>();
        for(int i = 0; i < stringArr.length; i++){
            newArr.add(stringArr[i]);
        }

        //map para guardar los elementos
        HashMap<Character, ArrayList<String>> map = new HashMap<>();

        //ordenamos dentro del map y devolvemos al newArr
        int pos = StringUtil.maxLength(stringArr) - 1;

        while(pos >= 0) {
            //seteamos los arrays del map
            for(Integer i = 0; i < 10; i++){
                map.put(i.toString().charAt(0), new ArrayList<>());
            }

            //pasamos los elementos del array al map
            for (int i = 0; i < newArr.size(); i++) {
                map.get(newArr.get(i).charAt(pos)).add(newArr.get(i));
            }

            //limpiamos el array y ordenamos los elemntos del map
            newArr.clear();
            for(Map.Entry<Character, ArrayList<String>> entry:map.entrySet()){
                for(int i = 0; i < entry.getValue().size(); i++){
                    newArr.add(entry.getValue().get(i));
                }
            }

            map.clear();
            pos--;
        }

        //pasamos al array de string para devolverlo a numeros
        for (int i = 0; i < stringArr.length; i++){
            stringArr[i] = newArr.get(i);
        }

        //pasamos a numeros y seteamos el array original
        int arrAux[] = StringUtil.toIntArray(stringArr);
        for(int i = 0; i < arr.length; i++){
            arr[i] = arrAux[i];
        }
    }

    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}
