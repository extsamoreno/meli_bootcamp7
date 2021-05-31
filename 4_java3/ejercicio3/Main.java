package ejercicio3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Integer arr[] = createIntArray(100000);

        ejercicio3.Sorter<Integer> sorter = (ejercicio3.Sorter) ejercicio3.MiFactory.getInstance("sorter");

        Comparator<Integer> c = (a,b)->a-b;

        ejercicio3.Timer t = new ejercicio3.Timer();
        t.comenzar();
        sorter.ordenar(arr,c);
        t.parar();
        System.out.println(t.tiempoTranscurrido());
    }

    private  static <T> void printArray(T arr[]) {
        for(T t:arr) {
            System.out.println(t);
        }
    }

    private static Integer[] createIntArray(int n) {
        Integer arr[] = new Integer[n];
        for(int i=n-1;i>=0; i--) {
            arr[n-i-1]=i;
        }

        return arr;
    }
}