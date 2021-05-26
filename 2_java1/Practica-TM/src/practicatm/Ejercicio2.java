package practicatm;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el número de m:  ");
        int m = input.nextInt();
        System.out.print("Ingrese la cantidad de múltiplos n:  ");
        int n = input.nextInt();

        for (int i = 0 ; i < n ; i++){

            System.out.println("El múltiplo nº" + (i+1) + " del número "+ m +" es: " + (m*i));
        }
    }
}
