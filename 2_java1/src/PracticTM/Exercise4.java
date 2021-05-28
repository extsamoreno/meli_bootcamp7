package PracticTM;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese n");
        int n = sc.nextInt();
        int i = 0;
        int j = 1;
        do {
            if (isPrime(j) == true) {
                System.out.println(j);
                i++;
            }
            j++;
        } while (i != n);

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
