package Eje1;

import java.util.Scanner;

public class Eje1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Hola! Por favor ingrese la cantidad de numeros: ");
        var n = s.nextInt();

        MostrarPares(n);
    }

    public static boolean EsPar(int num){
        return num % 2 == 0;
    }

    public static void MostrarPares(int n){
        for (int i = 1; i <= n; i++) {
            if (EsPar(i)) {
                System.out.println(i);
            }
        }
    }
}