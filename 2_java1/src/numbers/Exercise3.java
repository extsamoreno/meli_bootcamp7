package numbers;

import java.util.Scanner;

/*
Desarrollar un programa para informar si un número n es primo o no, siendo n un valor que el usuario ingresará por consola.
Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1.
 */
public class Exercise3 {

    public static void main(String[] args) {
        System.out.println("Ingrese que numero desea saber si es primo:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        float aux = 2;
        boolean isPrime;
        isPrime = Operations.isPrime(n);
        if(isPrime){
            System.out.println(n + " es Primo");
        }else{
            System.out.println(n + " NO es Primo");
        }
        scanner.close();
    }
}
