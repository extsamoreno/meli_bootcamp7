package PracticaTarde;

import java.lang.reflect.InvocationTargetException;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       Sorter <Integer>sorterInteger = (Sorter<Integer>) MiFactory.getInstance("MiFactory.properties");
       Sorter <String>sorterString = (Sorter<String>) MiFactory.getInstance("MiFactory.properties");


       Integer []arrInt= new Integer[10000];
       String arrString[] = new String[6];
       Timer t1= new Timer();


       // -------  Para INT ----------
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i]= (int)(Math.random()*10000);

        }
        t1.start();
        sorterInteger.sort((Integer[]) arrInt,(a,b)->a-b);
        t1.stop();
        for (int i = 0; i < arrInt.length; i++) {
            System.out.print(arrInt[i] + "   ");

        }
        System.out.println(" ");
        System.out.println("Tiempo transcurrido en milisegundos para ordenar enteros" + t1.elapsedTime());


        // ------- Para STRING-------

        for (int i = 0; i < arrString.length; i++) {
            arrString[i]="";

            for (int j = 0; j < 6; j++) {
                arrString[i]+= (char)(Math.random()*15+65);
            }
        }

        t1.start();
        sorterString.sort((String[]) arrString,(a,b)->a.compareTo(b));
        t1.stop();
        for (int i = 0; i < arrString.length; i++) {
            System.out.print(arrString[i] + "   ");

        }
        System.out.println(" ");
        System.out.println("Tiempo transcurrido en milisegundos para ordenar strings " + t1.elapsedTime());





    }
    }

