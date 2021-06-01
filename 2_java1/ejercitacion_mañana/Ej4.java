package ejercitacion_mañana;/*Desarrollar un programa para mostrar por consola los primeros n números primos,
siendo n un valor que el usuario ingresará por consola.
*/

import java.util.Scanner;

public class Ej4 {

    static boolean esPrimo(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n, i=0, numPrimo=2;
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números primos que desee ver: ");
        n = input.nextInt();

        System.out.println("Los primeros " + n + " primos son: ");
        while (i < n) {
            if (esPrimo(numPrimo)) {
                System.out.println(numPrimo);
                i++;
            }
            numPrimo++;
        }

        input.close();
    }
}
