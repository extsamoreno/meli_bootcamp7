package eje2;

import java.util.Scanner;

public class Eje2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Hola! Ingrese el valor base: ");
        int base = s.nextInt();

        System.out.print("Ingrese cuantos multiplos quiere: ");
        int multiplos = s.nextInt();

        MostrarMultiplos(base, multiplos);
    }

    private static void MostrarMultiplos(int base, int multiplos) {
        for (int i = 1; i <= multiplos; i++) {
            System.out.println(base * i);
        }
    }
}
