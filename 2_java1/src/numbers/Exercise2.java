package numbers;

import java.util.Scanner;

public class Exercise2 {
    /*Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores que el usuario ingresará
    por consola.
    Recordá que un número a es múltiplo de b si a es divisible por b.
         */
    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de multiplos que desea:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Ingrese de que número desea los multiplos:");
        int m = scanner.nextInt();
        int toPrint;
        if (n > 0){
            for (int i = 1; i <=n; i++) {
                toPrint = i * m;
                System.out.println(toPrint);

            }
        }
        scanner.close();
    }
}
