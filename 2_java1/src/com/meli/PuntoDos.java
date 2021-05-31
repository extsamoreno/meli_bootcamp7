package com.meli;

import java.util.Scanner;

import static com.meli.Titulo.titulo;

public class PuntoDos {
    public static void mostrarMultiplos (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese primer número: ");
        int primerNumero = scanner.nextInt();
        System.out.print("Por favor, ingrese segundo número: ");
        int segundoNumero = scanner.nextInt();
        System.out.println("Los primeros " + primerNumero + " multiplos de " + segundoNumero + " son: ");
        for (int i = 1; i <= primerNumero; i++) {
            if(segundoNumero%i == 0){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        titulo("Punto 2");
        mostrarMultiplos();
    }
}
