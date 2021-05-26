package numbers;

import java.util.Scanner;

public class Exercise4 {
    /*
    Desarrollar un programa para mostrar por consola los primeros n números primos, siendo n un valor que el usuario ingresará por consola.

     */
    public static void main(String[] args) {
        System.out.println("Ingrese que cantidad de primos deseas:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int prime = 2;
        while(n > 0){
            if(Operations.isPrime(prime)){
                System.out.println(prime);
                n--;
            }
            prime++;
        }
        scanner.close();
    }
}
