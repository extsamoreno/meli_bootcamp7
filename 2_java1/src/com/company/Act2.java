package com.company;
import java.util.Scanner;
public class Act2 {
    public static boolean isMultiplo(int dataN, int dataM){
        return dataN%dataM==0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cantidad de multiplos ");
        int valueN = sc.nextInt();
        System.out.println("Ingrese numero que seran multiplos de el ");
        int valueM = sc.nextInt();
        for(int i=1; i<valueN; i++){
            if (isMultiplo(valueM,i)){
                System.out.println(i);
            }
        }
    }
}
