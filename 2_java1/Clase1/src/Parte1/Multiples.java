package Parte1;

import java.util.Arrays;
import java.util.Scanner;

public class Multiples {

    public static void multiply(int multiple, int number){
        for (int i = 1; i <= number; i++) {
            System.out.printf("%d ", multiple * i);
        }
    }

    public static void main(String[] args) {
        System.out.print("Number to multiply: ");
        Scanner scanner  = new Scanner(System.in);
        int multiplyNum  = scanner.nextInt();
        System.out.print("How many multiples you want?: ");
        int numbers      = scanner.nextInt();
        multiply(multiplyNum, numbers);
    }
}
