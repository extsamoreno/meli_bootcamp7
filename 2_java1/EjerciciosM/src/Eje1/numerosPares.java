package Eje1;

import java.util.Scanner;

public class numerosPares {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        int numerosAMostrar;

        System.out.println("Ingrese un número entero para indicar la cantidad de números pares a mostrar");
        numerosAMostrar = teclado.nextInt();

        numerosPares(numerosAMostrar);
        System.out.println("-------Alternativa--------");
        funcionAlternativaNumerosPares(numerosAMostrar);

        teclado.close();
    }

    public static void numerosPares(int numerosAMostrar){
        int parMax= (numerosAMostrar -1 )*2 ;

        for (int i = 0; i<= parMax ; i+=2) {
            System.out.println(i);

        }

    }


    public static void funcionAlternativaNumerosPares(int numerosAMostrar){
        // Otra forma de hacerlo, pero que me parecio menos performante porque operaciones en cada ciclo es:

        int j=0;
        for (int i=0; i<numerosAMostrar; i++){
            if (j%2==0) {
                System.out.println(j);
                j++;
            }
            j++;
        }
    }



}
