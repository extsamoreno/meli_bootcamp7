package Eje1;

import java.util.Scanner;

public class NumerosMultiplos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        int numerosAMostrar;
        int numeroMultiplo;


        System.out.println("Ingrese la cantidad de números a mostrar");
        numerosAMostrar = teclado.nextInt();

        System.out.println("Ingrese el numero del que desea mostrar los múltiplos");
        numeroMultiplo= teclado.nextInt();



        for (int i = 1; i <= numerosAMostrar; i++) {
            System.out.println(numeroMultiplo*i);

        }



        teclado.close();


    }
}
