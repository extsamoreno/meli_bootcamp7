package Eje4;

import java.util.Scanner;

public class Eje4 {
    public static void main(String[] args) {
        System.out.print("Ingrese cuantos numeros primos necesita: ");
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            if (EsPrimo(i)){
                System.out.println(i);
            }
        }
    }

    public static void MostrarPrimos(int n){
        for (int i = 1; i < n; i++) {

        }
    }

    public static boolean EsPrimo(int n) {
        if (n > 3) {
            for (int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
