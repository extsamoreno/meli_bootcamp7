package practicaTM;

import java.util.Scanner;

public class Ejercicio2 {
    // Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores que el usuario ingresará por consola.
    // Recordá que un número a es múltiplo de b si a es divisible por b.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un numero del que quiere los multiplos:");
        int numeroBase = scanner.nextInt();

        System.out.println("Ingresa la cantidad de multiplos:");
        int cantMultiplos = scanner.nextInt();

        System.out.println("\nLos primeros " + cantMultiplos + " multiplos de " + numeroBase + " son:");

        int i = 1;
        while (i <= cantMultiplos) {
            System.out.println(i * numeroBase);
            i++;
        }

        scanner.close();
    }
}
