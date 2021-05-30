package bootcamp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class EjerciciosTarde {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Timer timer = new Timer();

        Sorter sorter = (Sorter) MiFactory.getInstance("src/bootcamp/MiFactory.properties");
//        Sort sorter = new Sort;
        Integer[] arrInt = {5, 9, 6, 8, 9,89, 1};
        String[] arrStr = {"Hola", "Todo", "Bien", "??", "Como","Estas", "Vos"};

        Comparator<Integer> c1 = (a, b)-> (a-b);
        Comparator<String> c2 = (a, b)-> (int) (a.charAt(0)- b.charAt(0));

        sorter.sort(arrInt,c1);
        Main.printArray(arrInt);

        sorter.sort(arrStr,c2);
        Main.printArray(arrStr);


        //
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1_000; i>0; i-- )
        {
            al.add(i);
        }

        System.out.println("al.toArray().length = " + al.toArray().length);
        timer.start();
        sorter.sort(al.toArray(),c1);
        timer.end();
        System.out.println("Elapsed Time = " + timer.elapsedTime());


    }
}
