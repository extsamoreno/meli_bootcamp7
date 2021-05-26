package com.company;
import java.util.Scanner;

public class Main {
    public static boolean multiple(int multiplo, int mul) {
        return multiplo%mul==0;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese numero ");
        int m = scanner.nextInt();

        System.out.println("Ingrese cant multiplo ");
        int n = scanner.nextInt();

        int multiplos = 0, i = 0;

        while(i != n) {
            if( multiple(multiplos, m) ) {
                System.out.println(multiplos);
                i++;
            }
            multiplos++;
        }

        scanner.close();
    }
    }

