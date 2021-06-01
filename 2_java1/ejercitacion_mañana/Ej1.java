package ejercitacion_mañana;/* Desarrollar un programa para mostrar los primeros n números pares,
siendo n un valor que el usuario ingresará por consola.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        int i = 0, n=0;
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de primeros números pares que desee ver: ");
        try {
            n = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error, deberías ingresar un número entero");
            main(args);
            System.exit(0);
        }

        System.out.println("Los primeros " + n + " números pares son: ");
        while (i < n) {
            System.out.println(i * 2);
            i++;
        }
        input.close();
    }
}
