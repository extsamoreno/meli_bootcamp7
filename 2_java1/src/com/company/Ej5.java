package com.company;

import java.util.*;

public class Ej5 {

    public void mostrarNaturales() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese cantidad de numeros a ver: ");
        int n = scanner.nextInt();

        System.out.println("Ingrese cantidad de repeticiones: ");
        int m = scanner.nextInt();

        System.out.println("Ingrese un valor a buscar: ");
        int d = scanner.nextInt();

        int naturalToShow = 1;

        while (n > 0) {
            if (containsChar(naturalToShow, m, d)) {
                System.out.println(naturalToShow);
                n--;
            }
            naturalToShow++;
        }
    }

    public boolean containsChar(int number, int m, int d) {

        String aux = String.valueOf(number);

        char myD = Character.forDigit(d, 10);

        if (aux.chars().filter(x -> x == myD).count() >= m) {
            return true;
        }
        return false;
    }

}
