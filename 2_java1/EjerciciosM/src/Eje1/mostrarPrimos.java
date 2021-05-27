package Eje1;

import java.util.Scanner;

public class mostrarPrimos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        int numerosAMostrar;


        System.out.println("Ingrese un número entero para indicar la cantidad de números primos a mostrar");
        numerosAMostrar = teclado.nextInt();

        mostrarNumerosPrimos(numerosAMostrar);


        teclado.close();
    }

    public static void mostrarNumerosPrimos(int numerosAMostrar){
        int i=3;
        int contador=0;

        if (numerosAMostrar>=1){
            System.out.println("2");
            contador++;
        }

        while (contador<numerosAMostrar){
            if (esPrimo(i)){
                contador++;
                System.out.println(i);
            }
            i+=2;  // Para evitar evaluar los números pares y el 2 lo analice aparte para que sea mas performante.
        }


    }

    public static boolean esPrimo(int numeroIngresado){

    boolean esPrimo=true;

        for (int i = 2; i < numeroIngresado; i++) {
        if (numeroIngresado % i == 0) {
            esPrimo = false;
            break;
        }
    }
        return esPrimo;

    }

}
