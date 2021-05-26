public class RadixSort {
    public static void radixSort(int []arr)
    {
        // Convertir el array que vamos a ordenar, de int[] a String[]
        //int newArr[] = new int[arr.length];
        String newArr[] = StringUtil.toStringArray(arr);

        // Normalizar el array
        StringUtil.lNormalize(newArr,'0');

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
