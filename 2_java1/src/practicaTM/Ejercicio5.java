package practicaTM;

import java.util.Scanner;

public class Ejercicio5 {

    //Desarrollar un programa para mostrar por consola los primeros n números naturales que tienen al menos m dígitos d,
    //siendo n, m y d valores que el usuario ingresará por consola.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la \"cantidad de numeros\", con \"cantidad de apariciones\" del \"digito\":");
        int cantidadNumeros = scanner.nextInt();
        int cantidadBuscada = scanner.nextInt();
        int digitoBuscado = scanner.nextInt();

        System.out.println("\nLos primeros " + cantidadNumeros + " numeros que \ncontienen " + cantidadBuscada + " digitos " + digitoBuscado + " son:");

        int numeroAIncrementar = 0;
        int i = 0;
        while (i < cantidadNumeros) {
            if (Utils.tieneLaCantidadBuscadaDeDigitos(numeroAIncrementar, digitoBuscado, cantidadBuscada)) {
                System.out.println(numeroAIncrementar);
                i++;
            }
            numeroAIncrementar++;
        }

        scanner.close();
    }


}
