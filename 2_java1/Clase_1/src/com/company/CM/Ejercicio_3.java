package com.company.CM;

import java.util.Scanner;

public class Ejercicio_3 {

    public boolean Primo(int iValor){

        int iContador=0;
        for (int i = 1; i <=iValor ; i++) {
            if(iValor%i==0){
                iContador=iContador+1;
            }
        }
        if(iContador==2){
            return true;
        }else{
            return false;
        }
    }

    public void Ejercicio(){
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese valor para validar si es primo");
        int iValor = read.nextInt();
        if(Primo (iValor)){
            System.out.println("Es primo");
        }else{
            System.out.println("No es primo");
        }
    }
}
