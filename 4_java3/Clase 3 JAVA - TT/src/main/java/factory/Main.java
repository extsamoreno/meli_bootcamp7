package factory;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Sorter aux = (Sorter) MiFactory.getInstance("sorter");
        Integer[] iArr = {9, 2, 1, 8, 5};
        String[] sArr = {"hola", "arbol", "un", "heladera", "perros"};

        aux.sort(iArr, Comparator.naturalOrder());
        aux.sort(sArr, Comparator.naturalOrder());


        for(int i = 0; i < iArr.length; i ++) {
            System.out.println(iArr[i]);
        }
        for(int i = 0; i < sArr.length; i ++) {
            System.out.println(sArr[i]);
        }

        Timer timer = new Timer();
        Integer[] array = new Integer[100];

        int pos = 0;
        for (int i = 100; i>0; i--){
            array[pos] = i;
            pos++;
        }

        timer.start();
        aux.sort(array, Comparator.naturalOrder());
        timer.stop();

        System.out.println("Tiempo de inicio: " + timer.getStartTime());
        System.out.println("Tiempo de finalizacion: " + timer.getEndTime());
        System.out.println("Tiempo transcurrido: " + timer.elapsedTime());
    }
}
