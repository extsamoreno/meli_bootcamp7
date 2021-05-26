package com.company;
import java.util.Scanner;
public class Ejercicio_2 {
    public void Multiplos(int iNumero,int iCantidad){
        int iContador=0;
        while (iCantidad!=0){
            iContador++;
            if(iContador%iNumero==0){
                System.out.println("Este numero "+iContador+" es multiplo de "+iNumero);
                iCantidad--;
            }
        }


    }

    public void Ejercicio(){
        Scanner read= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de multiplos que quiere visualizar");
        int iCantidad = read.nextInt();
        System.out.println("Ingrese el numero para hallar los multiplos");
        int iNumero = read.nextInt();
        Multiplos(iNumero,iCantidad);
    }
}
