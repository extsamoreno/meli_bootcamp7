// Desarrollar un programa para mostrar los primeros n números pares, siendo n un valor que el usuario ingresará por consola.

import java.util.Scanner;

public class MostrarPares {

    public static void mostrarPares (int n) {
        for (int i = 0; i < n * 2; i += 2) {
            System.out.println(i + 2);
        }
    }

    public static void main(String[] args) {
        int pares;
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Cuántos números pares quiere ver?");
        pares = entrada.nextInt();

        mostrarPares(pares);
    }
}