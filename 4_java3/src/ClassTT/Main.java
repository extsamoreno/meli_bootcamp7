package ClassTT;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int [] iArr= new int[100000];

        Random rd= new Random();
        
        for (int i = 0; i < iArr.length; i++) {
            iArr[i]= rd.nextInt();
        }

        Timer time= new Timer();
        time.start();

        time.stop();
        System.out.println(time.elapsedTime()+" ms");
    }
}
