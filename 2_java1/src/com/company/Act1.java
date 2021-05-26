package com.company;
import java.util.Scanner;

public class Act1 {

    public static boolean isPar(int data){
        return data%2==0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    System.out.println("Ingrese un número");
	    int value = 0;
        value = sc.nextInt();
        int iterable = 2;
        System.out.println(0);
        for(int i=0; i<value-1; i++){
            System.out.println(iterable);
            iterable = iterable * 2;
        }
    }
}
