package ejercitacion_mañana;/* Desarrollar un programa para informar si un número n es primo o no,
siendo n un valor que el usuario ingresará por consola.*/

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        System.out.print("Introduce un número para saber si es primo: ");
        num = input.nextInt();

        for (int i = 2; i <= num / 2; i++) {
            flag = num % i == 0 ? true : flag;
            break;
        }

        if (!flag)
            System.out.println(num + " es un número primo.");
        else
            System.out.println(num + " no es un número primo.");

        input.close();
    }
}
