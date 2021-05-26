package practicaTM;

import java.util.Scanner;

public class Ejercicio1 {
    // Desarrollar un programa para mostrar los primeros n números pares, siendo n un valor que el usuario ingresará por consola.
    // Recordá que un número es par cuando es divisible por 2.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un numero:");
        int numero = scanner.nextInt();

        System.out.println("\nLos primeros " + numero + " numeros pares son:");

        int i = 0;
        while (numero != 0) {
            if (Utils.esMultiploDe(i, 2)) {
                System.out.println(i);
                numero--;
            }
            i++;
        }

        scanner.close();
    }
}
