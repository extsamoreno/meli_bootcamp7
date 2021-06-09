public class MainTT {
    public static void main(String[] args) {

        Integer arr[] = {5,6,8,9,4,3};
        QuickSorterImple<Integer> objeto = new QuickSorterImple<>();
        objeto.sort(arr,(a,b)-> a-b);

    }


}
