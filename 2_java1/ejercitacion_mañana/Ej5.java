package ejercitacion_mañana;/*Desarrollar un programa para mostrar por consola los primeros n números naturales
que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará.

Por ejemplo: si el usuario ingresa n=5, m=2 y d=3,
la salida será: 33, 133, 233, 303, 313.*/

import java.util.Scanner;

public class Ej5 {

    public static void getNumbers(int n, int m, int d) {
        int cantNum = 0, countM = 0, i = 1, num;
        System.out.println("Lista de hasta " + n + " números naturales " +
                "que tienen al menos " + m + " dígitos " + d);
        while (cantNum != n) {
            num = i;
            while (num != 0) {
                if (num % 10 == d) {
                    countM++;
                }
                num = num / 10; //para cortar el while y separas por decena,centena,etc
            }
            if (countM >= m) {
                System.out.println(i);
                cantNum++;
            }
            countM = 0;
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m, d;

        System.out.print("Ingrese un valor n: ");
        n = s.nextInt();
        System.out.print("Ingrese un valor m: ");
        m = s.nextInt();
        System.out.print("Ingrese un valor d: ");
        d = s.nextInt();
        n=5;m=1;d=1;
        getNumbers(n, m, d);
    }
}
