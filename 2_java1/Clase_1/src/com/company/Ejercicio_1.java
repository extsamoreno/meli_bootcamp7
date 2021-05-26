package com.company;

import java.util.Scanner;

public class Ejercicio_1 {

    public  boolean Pares(int iNumero){

        if(iNumero%2==0){

            return true;
        }else{
            return false;
        }

    }

    public  void Ejericio(){
        System.out.println("Ingrese valor para verificar si es par");
        Scanner Read = new Scanner(System.in);
        int iPares =  Read.nextInt();
        for (int i = 0; i <=iPares; i++) {
            if(Pares(i)){
                System.out.println("Numero par "+i);
            }
        }
    }
}
