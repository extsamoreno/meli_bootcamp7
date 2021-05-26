package com.company;

import java.util.Scanner;

public class Punto_5 {
    public boolean ExtaerDigitos(int iValor,int iDigito,int iCantDigitos){

        char b = (char)(iDigito +'0');

        String x = Integer.toString(iValor);
        int iContador=0;
        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i)==b){
                iContador=iContador+1;
            }
        }
        if(iContador==iCantDigitos){
            return true;
        }else{
            return false;
        }
    }



    public void Naturales(int iCantidad,int iDigitos,int iNumero){
        int iContador=0;
        while (iCantidad!=0){
            iContador++;
            if(ExtaerDigitos(iContador,iNumero,iDigitos)){
                System.out.println(iContador+" Cumple");
                iCantidad--;
            }
        }
    }




    public void Ejercicio() {
        Scanner read = new Scanner(System.in);
        System.out.println("Cantidad de numeros a visualizar");
        int iCantidad = read.nextInt();
        System.out.println("Cantidad de digitos a visualizar");
        int iDigitos = read.nextInt();
        System.out.println("Numero a visualizar");
        int iNumero = read.nextInt();
        System.out.println();
        Naturales(iCantidad, iDigitos, iNumero);
    }

    }
