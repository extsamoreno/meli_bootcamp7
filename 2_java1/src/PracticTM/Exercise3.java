package PracticTM;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese n");
        int n = sc.nextInt();
        System.out.println(isPrime(n));
    }

    public static boolean isPrime(int n) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cont++;
            }
        }
        if (cont < 3)
            return true;
        return false;
    }
}
