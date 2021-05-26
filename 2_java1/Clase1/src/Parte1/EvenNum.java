package Parte1;

import java.util.Scanner;

public class EvenNum {

    public static void even(int num){
        for (int i = 0; i <= num; i++)
            if (i % 2 == 0)
                System.out.println( i + " is even.");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number: ");
        int num = scanner.nextInt();
        even(num);

    }
}
