
// Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores que el usuario ingresará por consola.

import java.util.Scanner;

public class MostrarMultiplos {

    public static void mostrarMultiplos (int n, int m) {
        int c = 0;
        for (int i = 2; i < m; i++) {
            if (m % i == 0) {
                System.out.print(i + "\t ");
                c++;
            }
            if (c == n) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n, m;

        System.out.println("¿De cuál número quiere conocer sus múltiplos?");
        m = entrada.nextInt();

        System.out.println("¿Cuántos de sus múltiplos quisiera ver, comenzando por el menor?");
        n = entrada.nextInt();
        System.out.println();

        mostrarMultiplos(n, m);
    }
}