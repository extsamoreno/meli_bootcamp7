package practicatm;

import java.util.Scanner;

public class Ejercicio4 {
    static boolean esPrimo(int n) {
        int cant_divisores = 0;
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                cant_divisores++;
            }
            i++;
        }
        if (cant_divisores == 0 && n>1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese cantidad de primos: ");
        int cantidad = input.nextInt();
        int contador=1;
        int num=1;

        if (cantidad<1){
            System.out.println("Se ingreso un numero menor a 1");
            System.out.println("se calulará 1 numero primo: ");
            cantidad = 1;
        }
        System.out.print("Secuencia: ");
        while (contador<=cantidad){
            if(esPrimo(num)){
                System.out.print(num+", ");
                contador++;
            }
            num++;
        }
    }
}
