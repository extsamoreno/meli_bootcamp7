// Desarrollar un programa para informar si un número n es primo o no, siendo n un valor que el usuario ingresará por consola.

import java.util.Scanner;

public class EsPrimo {

    public static boolean esPrimo(int n) {
        boolean p = false;
        int c = 0;
        for (int i = n; i > 0; i--) {
            if (n % i == 0) {
                c++;
            }
        }
            if (c == 2) {
                p = true;
            }
            return p;
    }

    public static void main(String[] args) {
        int n;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Por favor, ingrese un número");
        n = entrada.nextInt();

        if (esPrimo(n)) {
            System.out.println("El número es primo");
        } else {
            System.out.println("El número no es primo");
        }
    }

}