package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        Random rand = new Random();
        Integer[] arr = new Integer[100000];

        for (int i = 0; i < arr.length; ++i)
            arr[i] = rand.nextInt(100000);

        Sorter<Integer> sorter = (Sorter<Integer>) MiFactory.getInstance("MiFactory.properties");

        Timer timer = new Timer();

        timer.start();
        sorter.sort(arr, (a, b) -> a-b);
        timer.stop();

        System.out.println(timer.elapsedTime()+" ms");
    }
}
