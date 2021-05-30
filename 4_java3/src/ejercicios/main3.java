package ejercicios;

import java.util.Comparator;


public class main3 {
    public static void main(String[] args) {
        Sorter sorter = (Sorter) MyFactory.getInstance("BubbleSortSorterImple");
        //Sorter sorter = (Sorter) MyFactory.getInstance("HeapSortSorterImple");
//      Sorter sorter = (Sorter) MyFactory.getInstance("QuickSortSorterImple");

        Comparator<Integer> c= (c1,c2)->(c1-c2);
/*        Integer arrIPrueba[] = {2,3,12,45,5,6,12,45,56};
        int longitud= arrIPrueba.length;
        sorter.sort(arrIPrueba, c);
        System.out.println("Prueba con Integer");
        for (int i= 0; i<longitud ; i++) System.out.print(arrIPrueba[i] + " ");
        System.out.println("\n");*/


/*        Comparator s = new compareString();
        String arrSPrueba[] ={"asd","tengo","for","utilidad", "queso", "pan"};
        sorter.sort(arrSPrueba,s);
        System.out.println("Prueba con Strings");
        for (int i= arrSPrueba.length-1 ; i>=0 ; i-- ) System.out.print(arrSPrueba[i] + " ");
        System.out.println("\n");*/

        Integer arr[] = new Integer[100000];

        for (int i = 0; i < 100000 ; i++) {
            arr[i]= 100000-i;
        }

        Time time = new Time();

        time.startTime();
        sorter.sort(arr, c);
        time.stopTime();

        System.out.println("Array ordenado");
        for (int i= 0; i<arr.length ; i++) System.out.print(arr [i]+ " ");
        System.out.println("\n");
        System.out.println("Tiempo de Ejecucion: " +time.enlapsedTime() + " miliseg");

    }
}
