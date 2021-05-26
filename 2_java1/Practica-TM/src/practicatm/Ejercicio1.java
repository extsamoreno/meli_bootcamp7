package practicatm;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el valor de n:  ");
        int n = input.nextInt();

        for (int i = 0 ; i < n ; i++){

            System.out.println("Numero par nº" + (i+1) + " es: " + (2*i));
        }
    }
}
