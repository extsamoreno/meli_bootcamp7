package practicaTM;

import java.util.Scanner;

public class Ejercicio4 {

    //Desarrollar un programa para mostrar por consola los primeros n números primos, siendo n un valor que el usuario
    //ingresará por consola.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la cantidad de numeros primos que desea ver:");
        int cantidadPrimos = scanner.nextInt();

        int i = 1;
        int numeroAIncrementar = 1;
        while (i <= cantidadPrimos) {

            if (Utils.esPrimo(numeroAIncrementar)) {
                System.out.println("El " + i + " numero primo es: " + numeroAIncrementar);
                i++;
            }
            numeroAIncrementar++;
        }
        scanner.close();
    }


}
