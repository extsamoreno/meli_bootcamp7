
// Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores que el usuario ingresará por consola.

import java.util.Scanner;

public class mostrarMultiplos {

    public static void mostrarMultiplos (int n, int m) {
        for (int i = 0; i < n * m; i += m) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int numeros, multiplos;
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Cuántos múltiplos quiere ver?");
        numeros = entrada.nextInt();

        System.out.println("¿Cuál es el número del cual quiere ver los múltiplos?");
        multiplos = entrada.nextInt();
    }
}