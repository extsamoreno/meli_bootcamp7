package numbers;

import java.util.Scanner;

public class Exercise1 {
    /*Desarrollar un programa para mostrar los primeros n números pares, siendo n un valor que el usuario ingresará por
    consola.
    Recordá que un número es par cuando es divisible por 2*/


    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de pares que desea:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int initial = 1;
        if (n > 0) {
            n--;
            System.out.println(0);
            for (; n > 0; n--) {
                initial = initial*2;
                System.out.println(initial);
            }
        }
        scanner.close();
    }
}
