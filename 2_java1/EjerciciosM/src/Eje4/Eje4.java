package Eje4;

import java.util.Scanner;

public class Eje4 {
    public static void main(String[] args) {
        System.out.print("Ingrese cuantos numeros primos necesita: ");
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        MostrarPrimos(n);
    }

    public static void MostrarPrimos(int n){
        int primosMostrados = 0;
        int base = 1;
        while (primosMostrados < n){
            if (EsPrimo(base)){
                primosMostrados++;
                System.out.println(base);
            }
            base++;
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
