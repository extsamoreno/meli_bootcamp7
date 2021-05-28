package ejercicio_tarde;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Object[] ejemplo = {14,8,12,1,10,9,2,6};
        Comparator c = new ComparatorStringAscImpl();
        //Sorter sorter = (Sorter) MiFactory.getInstance("QuickSortSorterImple");
        //Sorter sorter = (Sorter) MiFactory.getInstance("HeapSortSorterImple");
        Sorter sorter = (Sorter) MiFactory.getInstance("BubbleSortSorterImple");
        sorter.sort(ejemplo,c);
        for (int i = 0; i< ejemplo.length;i++){
            System.out.println(ejemplo[i]);
        }
        System.out.println();
        Time time = new Time();
        Object[] ejemplo1 = new Object[100000];
        for (int k=100000;k>0;k--){
            ejemplo1[k-1]=k;
        }
        Comparator comparator = new ComparatorStringAscImpl();
        //Sorter sorter1 = (Sorter) MiFactory.getInstance("BubbleSortSorterImple");
        Sorter sorter1 = (Sorter) MiFactory.getInstance("HeapSortSorterImple");
        time.start();
        sorter1.sort(ejemplo1,comparator);
        time.stop();
        System.out.println("Tiempo total de ejecución: "+time.elapsedTime());
        // Respuesta pregunta 14: El algoritmo tardó 1688 milisegundos en ejecutarse con el algoritmo de BubbleSortImple
        // Respuesta pregunta 15: El algoritmo tardó 52 milisegundos en ejecutarse con el algoritmo de HeapSortSorterImple


    }

}
