package numbers;

import java.util.Scanner;
/*
Desarrollar un programa para mostrar por consola los primeros n
números naturales que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
 */
public class Exercise5 {
    public static void main(String[] args) {

        System.out.println("Ingrese la cantidad de resultados que deseas:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Que numero  :");
        int m = scanner.nextInt();
        System.out.println("Ingrese que cantidad de primos deseas:");
        int d = scanner.nextInt();
    }
}
