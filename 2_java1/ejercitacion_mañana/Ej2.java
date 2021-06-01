package ejercitacion_mañana;/* Desarrollar un programa para mostrar los primeros n múltiplos de m,
siendo n y m valores que el usuario ingresará por consola.
 */

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese un número para saber sus múltiplos: ");
        int m = input.nextInt();
        System.out.print("Ingrese la cantidad de múltiplos que desee ver: ");
        int n = input.nextInt();

        System.out.println("Los primeros " + n + " múltiplos de " + m + " son:");
        for (int i = 1; i <= n; i++) {
            System.out.println(m * i);
        }

        input.close();

    }
}
