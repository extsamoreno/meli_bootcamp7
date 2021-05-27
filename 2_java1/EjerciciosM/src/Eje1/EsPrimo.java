package Eje1;

import java.util.Scanner;

public class EsPrimo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numeroIngresado;
        boolean esPrimo = true;


        System.out.println("Ingrese un número entero");
        numeroIngresado = teclado.nextInt();


        for (int i = 2; i < numeroIngresado; i++) {
            if (numeroIngresado % i == 0) {
                esPrimo = false;
                break;
            }
        }

        if (esPrimo) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
        teclado.close();
    }
}
