package Exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class Multiples {
    static ArrayList<Integer> getMultiples(int multiple, int count){
        ArrayList<Integer> multiples = new ArrayList<Integer>();
        short countList = 0;
        for(int i=1;i<=count;i++){
            if(i%multiple==0)
                multiples.add(i);
        }
        return multiples;
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("Escribe el multiplo");
        int multiple = user.nextInt();
        System.out.println("Escribe el numero");
        int count = user.nextInt();
        ArrayList<Integer> multipleOf = getMultiples(multiple,count);
        for(int number : multipleOf){
            System.out.println(number);
        }
    }
}
