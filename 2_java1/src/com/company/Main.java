package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //primerosPares();
        //primerosMultiplos();
        //esPrimo();
        //primerosPrimos();
        primerasCombinaciones(5,3,3);
    }

    public static void primerosPares(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos numeros pares desea ver?");
        int n = scanner.nextInt();

        System.out.println("Primeros "+n+" numeros pares");
        for(int i=0 ; i<n ; i++){
            System.out.println(2*(i+1));
        }
        scanner.close();
    }

    public static void primerosMultiplos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que numero desea multiplicar?");
        int m = scanner.nextInt();
        System.out.println("Cuantos multiplos desea ver?");
        int n = scanner.nextInt();

        System.out.println("Primeros "+n+" ultiplos de "+m);
        for(int i=0 ; i<n ; i++){
            System.out.println(m*(i+1));
        }
        scanner.close();
    }

    public static void isPrime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que numero desea comprobar?");
        int n = scanner.nextInt();
        boolean prime=isPrime(n);
        if(prime){
            System.out.println("El numero "+n+" es primo");
        }else{
            System.out.println("El numero "+n+" no es primo");
        }
        scanner.close();
    }

    public static void primerosPrimos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos numeros primos desea ver?");
        int n = scanner.nextInt();
        int count=0;
        int i=1;

        while (count<n){
            if(isPrime(i)){
                System.out.println(i);
                count++;
            }
            i++;
        }

        scanner.close();
    }

    public static void primerasCombinaciones(int n, int m, int d){
        int count=0;
        int num=d;
        while(count<n){
            if(sirve(num,m,d)){
                System.out.println(num);
                count++;
            }
            num++;
        }
    }

    public static boolean  sirve(int num, int m, int d){
        String numero=String.valueOf(num);
        boolean sirve=false;
        int rep=0;
        for(int i=0 ; i<numero.length() && !sirve ; i++){
            if(Integer.parseInt(numero.charAt(i)+"")==d){
                rep++;
                if(rep==m){
                    sirve=true;
                }
            }
        }
        return sirve;
    }

    public static boolean isPrime(int n){
        boolean prime=true;
        for(int i=2 ; i<=n/2 && !false ; i++){
            if(n%i == 0){
                prime=false;
            }
        }
        return prime;
    }
}
