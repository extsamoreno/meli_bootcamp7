package PracticTM;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese n");
        int n = sc.nextInt();
        System.out.println("Ingrese m");
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(m*i);
        }
    }
}
