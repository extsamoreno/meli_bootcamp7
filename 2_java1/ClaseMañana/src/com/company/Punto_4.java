package com.company;

import java.util.Scanner;

public class Punto_4 {
    public void n_Primos(int iValores){

        Punto_3 ejer= new Punto_3();
        int iContador=0;
        while (iValores!=0){
            iContador++;
            if(ejer.Primo(iContador)){
                System.out.println(iContador+" es numero es primo");
                iValores--;
            }
        }

    }

    public void Ejercicio() {
        Scanner read = new Scanner(System.in);
        System.out.println("Cantidad de numeros primos a visualizar ∫");
        int iValor = read.nextInt();
        n_Primos(iValor);
    }
    }
