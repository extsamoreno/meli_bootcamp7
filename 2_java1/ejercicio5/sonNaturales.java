package ejercicio5;

import java.util.Scanner;

public class sonNaturales {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola! Este programa le permitirá saber la cantidad de números naturales que desee, teniendo en cuenta un dígito deseado para esos números y la cantidad mínima de repeticiones de ese dígito :)");

        System.out.println("Ingrese la cantidad de números naturales que desea saber: ");
        int cantNaturales = scanner.nextInt();

        System.out.println("Ingrese el dígito que desea que posea el número natural: ");
        int digitoDeseado = scanner.nextInt();

        System.out.println("Ingrese la cantidad mínima de repeticiones del dígito deseado: ");
        int cantDigitoDeseado = scanner.nextInt();

        int count = 0;
        int numeroNatural = 0;
        while(count < cantNaturales){
            int cantRepeticionesDigitoDeseado = 0;
            int auxNumeroNatural = numeroNatural;

            while(auxNumeroNatural > 0){
                if(auxNumeroNatural % 10 == digitoDeseado){
                    cantRepeticionesDigitoDeseado++;
                }
                auxNumeroNatural = auxNumeroNatural/10;
            }

            if(cantRepeticionesDigitoDeseado >= cantDigitoDeseado){
                System.out.println("El número natural " + numeroNatural + " responde a todas las especificaciones deseadas");
                count++;
            }

            numeroNatural++;
        }

        scanner.close();
    }
}