package Eje5;

import java.util.Scanner;

public class Eje5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese cantidad de numeros: ");
        int cantidad = s.nextInt();
        System.out.print("Ingrese cantidad de digitos: ");
        int repetidos = s.nextInt();
        System.out.print("Ingrese digito: ");
        int digito = s.nextInt();

        mostrarNumeros(cantidad, repetidos, digito);
    }

    public static void mostrarNumeros(int cantidad, int repetidos, int digito){
        int cantidadMostrada = 0;
        int base = repetidos == 1 ? 0 : (int)Math.pow(10,repetidos);
        while (cantidadMostrada < cantidad){
            if (incluyeNVeces(base, repetidos, digito)){
                System.out.println(base);
                cantidadMostrada++;
            }
            base++;
        }
    }

    public static boolean incluyeNVeces (int numero, int n, int digito){
        int cont = 0;
        String numString = String.valueOf(numero);
        for (char digString : numString.toCharArray()){
            if (Character.toString(digString).equals(Integer.toString(digito))){
                cont++;
            }
        }
        return cont == n;
    }
}
