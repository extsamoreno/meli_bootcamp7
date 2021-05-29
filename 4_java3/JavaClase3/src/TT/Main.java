package TT;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1,5,3,6,3,6,7,4};

        QuickSort<Integer> objeto = new QuickSort();
        objeto.sort(arr,(a,b)-> a-b);
        for (Integer n :
                arr) {
            System.out.println(n);
        }

    }
}
