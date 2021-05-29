package Parte2;

public class Main {
    public static void main(String[] args) {
        Integer arr[] = {1,2,5,2,29,6,5};
        showArr(arr);
        //QuickSortSorterImple q = new QuickSortSorterImple();
        //HeapSortSorterImple q = new HeapSortSorterImple();
        BurbleSortSorterImple q = new BurbleSortSorterImple();
        System.out.println(" ");
        q.sort(arr, (a, b)->a-b);
        showArr(arr);

    }

    public static <T> void showArr(T[] arr){
        for (T t: arr) {
            System.out.print(t + " ");
        }
    }
}
