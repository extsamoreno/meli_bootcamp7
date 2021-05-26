package Eje3;

import java.util.Scanner;

public class Eje3 {
    public static void main(String[] args) {
        System.out.print("Ingrese el numero a verificar: ");
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        System.out.println(EsPrimo(n));
    }

    public static boolean EsPrimo(int n) {
        if (n > 3) {
            for (int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
