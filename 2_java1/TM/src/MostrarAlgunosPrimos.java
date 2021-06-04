// Desarrollar un programa para mostrar por consola los primeros n números primos, siendo n un valor que el usuario ingresará por consola.

import java.util.Scanner;

public class MostrarAlgunosPrimos {

    public static void mostrarAlgunosPrimos (int n) {
        EsPrimo p = new EsPrimo();
        int c = 0;
        int i = 1;

        while (c != n) {
            if (p.esPrimo(i)) {
                c++;
                System.out.println(i + "\t");
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Cuántos números primos quiere ver, comenzando desde cero?");
        n = entrada.nextInt();

        System.out.println();
        mostrarAlgunosPrimos(n);
    }
}