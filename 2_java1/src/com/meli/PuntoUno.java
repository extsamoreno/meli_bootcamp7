package com.meli;

import java.util.Scanner;

import static com.meli.Titulo.titulo;

public class PuntoUno {
    public static void mostrarNumerosPares (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese un número: ");
        int numero = scanner.nextInt();
        System.out.println("Los numeros pares desde 0 hasta " + numero + " son: ");
        for (int i = 0; i <= numero; i++) {
            if(i%2 == 0){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        titulo("Punto 1");
        mostrarNumerosPares();
    }
}