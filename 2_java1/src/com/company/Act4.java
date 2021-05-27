package com.company;
import java.util.Scanner;
public class Act4 {
    public static boolean isPrimno(int data){
        if (data == 0 || data == 1 || data == 4) {
            return false;
        }
        for (int x = 2; x < data / 2; x++) {
            if (data % x == 0)
                return false;
        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cantidad de númerps primo ");
        int value = sc.nextInt();
        if (isPrimno(value)){
            System.out.println(value+" es primo");
        }else {
            System.out.println(value+" no es primo");
        }
    }
}
