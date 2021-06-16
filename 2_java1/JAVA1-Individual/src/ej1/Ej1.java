package ej1;

public class Ej1 {

    /*
     Desarrollar un programa para mostrar los primeros n números pares,
     siendo n un valor que el usuario ingresará por consola.
     Recordá que un número es par cuando es divisible por 2.
     */

    public static void main (String[] args) {
        int n = 10;
        firstNPairNumbers(n);
    }

    public static void firstNPairNumbers(int n) {
        int number = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(number);
            number += 2;
        }
    }

}
