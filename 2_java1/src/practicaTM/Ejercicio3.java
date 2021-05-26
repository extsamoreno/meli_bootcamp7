package practicaTM;

import java.util.Scanner;

public class Ejercicio3 {

    //Desarrollar un programa para informar si un número n es primo o no, siendo n un valor que el usuario ingresará por consola.
    //Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un numero del que desea saber si es primo:");
        int numeroBase = scanner.nextInt();

        if (Utils.esPrimo(numeroBase)) {
            System.out.println("El numero " + numeroBase + " es Primo.");
        } else {
            System.out.println("El numero " + numeroBase + " no es Primo.");
        }
        scanner.close();
    }


}
