import Ejercicios.*;
import java.util.Scanner;

import static Ejercicios.Ejercicio2.multiplos;

public class Main {
    public static void main(String[] args) {
        //boolean primo;
        Scanner scanner = new Scanner(System.in);
        int n, m;

        System.out.println("MENU:");
        System.out.println("Seleccione el ejercicio:");
        System.out.println("1. Números pares.");
        System.out.println("2. Múltiplos de m.");
        System.out.println("3. Número primo.");
        System.out.println("4. Números primos menores a n.");
        System.out.println("5. .");
        System.out.println(" ");
        int menu = scanner.nextInt();
        System.out.println(" ");

        switch (menu){
            case 1:
                System.out.println("PRIMEROS n NÚMEROS PARES:");
                System.out.println("Ingresa un número entero:");
                n = scanner.nextInt();
                Ejercicio1.pares(n);
                System.out.println(" ");
                break;

            case 2:
                System.out.println("PRIMEROS n MÚLTIPLOS DE m:");
                System.out.println("Ingresa el valor de m:");
                m = scanner.nextInt();
                System.out.println("Ingresa la cantidad de multiplos n:");
                n = scanner.nextInt();
                Ejercicio2.multiplos(m,n);
                System.out.println(" ");
                break;

            case 3:
                System.out.println("n ES NÚMERO PRIMO?:");
                System.out.println("Ingresa el valor de n:");
                n = scanner.nextInt();
                boolean primo = Ejercicio3.es_primo(n);
                System.out.print(primo?"Es primo":"NO es primo");
                System.out.println(" ");
                break;

            case 4:
                System.out.println("NÚMEROS PRIMOS MENORES A n:");
                System.out.println("Ingresa el valor de n:");
                n = scanner.nextInt();
                Ejercicio4.primosMenores(n);
                System.out.println(" ");
                break;

            case 5:

        }
    }
}
