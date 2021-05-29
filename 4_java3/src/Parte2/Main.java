package Parte2;

public class Main {
    public static void main(String[] args) {
        Integer arr[] = {1,2,5,2,29,6,5};
        showArr(arr);

        Sorter q = (Sorter) MiFactory.getInstance("sorterB");

        //QuickSortSorterImple q = new QuickSortSorterImple();
        //HeapSortSorterImple q = new HeapSortSorterImple();
        //BurbleSortSorterImple q = new BurbleSortSorterImple();

        System.out.println(" ");
        q.sort(arr, (a, b)->a-b);
        showArr(arr);
        System.out.println("\n----- . ---- . ----- . ---- . ----");

        String[] arr1 = {"Nicoll", "Alejandro", "Daniel", "David"};
        showArr(arr1);

        Sorter head = (Sorter) MiFactory.getInstance("sorterH");

        System.out.println(" ");
        q.sort(arr1, (a, b)->a.compareTo(b));
        showArr(arr1);

    }

    public static <T> void showArr(T[] arr){
        for (T t: arr) {
            System.out.print(t + " ");
        }
    }
}
