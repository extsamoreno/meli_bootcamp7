package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Menu:\n1.Ejercicio1\n2.Ejercicio2\n3.Ejercicio3\n4.Ejercicio4\n5.Ejercicio5");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                firstNEven();
                break;
            case 2:
                firstNMultiples();
                break;
            case 3:
                System.out.println("Ingrese numero para verificar:");
                int numero = scanner.nextInt();
                boolean aux = isPrime(numero);
                if (aux) {
                    System.out.println("Primo");
                } else {
                    System.out.println("No Primo");
                }

                break;
            case 4:
                firstNPrimes();
                break;
            case 5:
                occurencias();
                break;
            default:
                // The user input an unexpected choice.
        }
    }

    //Ejercicio 1
    public static void firstNEven() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese cantidad de primeros numeros pares que desea mostrar:");

        int totalPrint = scan.nextInt();

        scan.close();

        int impresos = 0;
        for(int i = 1; impresos < totalPrint; i++) {
            if (i/2 == (double)i/2) {
                System.out.println(i);
                impresos++;
            }
        }
    }


    //Ejercicio 2
    public static void firstNMultiples() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese n (cantidad de multplos a imprimir):");
        int totalPrint = scan.nextInt();

        System.out.println("Ingrese m (numero del que se toman multiplos):");
        int subject = scan.nextInt();

        //scan.close();

        int impresos = 0;
        for(int i = 0; impresos < totalPrint; i++) {
            System.out.println(i*subject);
            impresos++;
        }
    }


    //Ejercicio 3
    public static boolean isPrime(int number) {
        //Utilizo 6k+-1
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese numero:");

        int number = scan.nextInt();

        scan.close();*/
        if (number <= 1) {return false;}
        if (number <= 3) {return true;}

        if ((number % 2 == 0) || (number % 3 == 0)) {return false;}

        int count = 5;
        while (count*count <= number) {
            if (number % count == 0 || number % (count + 2) == 0) {return false;}

            count += 6;
        }

        return true;
    }


    //Ejercicio 4
    public static void  firstNPrimes() {
        //Utilizo 6k+-1
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese cantidad de primos:");

        int totalPrint = scan.nextInt();
        scan.close();

        if (totalPrint >= 2) {
            System.out.println(2);
            System.out.println(3);
        } else if (totalPrint == 1) System.out.println(2);

        int printedInt = 2;
        for(int i = 5; printedInt < totalPrint; i+=6) {
            if (isPrime(i)) {
                System.out.println(i);
                printedInt++;
            }

            if (printedInt < totalPrint && isPrime(2+i)) {
                System.out.println(2+i);
                printedInt++;
            }
        }
    }

    //Ejercicio 5
    public static void occurencias() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese n (cantidad de multplos a imprimir):");
        int totalPrint = scan.nextInt();

        System.out.println("Ingrese m (tener almenos m digitos):");
        int m = scan.nextInt();

        System.out.println("Ingrese d (digito buscado):");
        int digito = scan.nextInt();

        scan.close();

        for (int i = 0; totalPrint > 0; i++) {
            int count = 0;
            int aux = i;
            while (aux > 0) {
                if (aux % 10 == digito)
                    count++;
                aux = aux / 10;
            }
            if (count == m) {
                totalPrint--;
                System.out.println(i);
            }
        }

    }
}