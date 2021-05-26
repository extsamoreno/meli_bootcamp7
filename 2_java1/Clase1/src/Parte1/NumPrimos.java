package Parte1;

import java.util.Scanner;

public class NumPrimos {
    public  static void primo(int num){

            if (!(num % 2 == 0) &&
                    !(num % 3 == 0) &&
                    !(num % 5 == 0) &&
                    !(num % 7 == 0) ||
                    (num == 2 || num == 5 || num == 3 || num == 7 || num != 1)){
                System.out.println(num + " es primo");
            }
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = scanner.nextInt();
        primo(num);
    }
}
