package Parte1;

import java.util.Scanner;

public class Primos {
    public  static void primo(int num){
        for (int i = 0; i < num; i++) {
            if (!(i % 2 == 0) &&
                    !(i % 3 == 0) &&
                    !(i % 5 == 0) &&
                    !(i % 7 == 0) ||
                    (i == 2 || i == 5 || i == 3 || i == 7)){
                System.out.println("Es primo " + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = scanner.nextInt();
        primo(num);
    }
}
