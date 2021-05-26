package practicatm;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.printf("Ingrese un número mayor a 0: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("El número debe ser mayor a 0!!!   ");
        } else {
            int cant_divisores = 0;
            int i = 2;
            while (i < n) {
                if (n % i == 0) {
                    cant_divisores++;
                }
                i++;
            }
            if (cant_divisores == 0 && n>1) {
                System.out.println("El número "+ n +" es primo");
            } else {
                System.out.println("El número "+ n + " no es primo");
            }
        }
    }
}
