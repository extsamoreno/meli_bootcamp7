package com.company;

import java.util.Scanner;

public class Ejercicio_4 {


    public void n_Primos(int iValores){

        Ejercicio_3 ejer= new Ejercicio_3();
        int iContador=0;
        while (iValores!=0){
            iContador++;
            if(ejer.Primo(iContador)){
                System.out.println(iContador+" es numero es primo");
                iValores--;
            }
        }

    }

    public void Ejercicio(){
        Scanner read = new Scanner(System.in);
        System.out.println("Cantidad de primos a visualizar ∫");
        int iValor = read.nextInt();
        n_Primos(iValor);

    }
}
