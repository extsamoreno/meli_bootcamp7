package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }

    public static void Exercice1() {
        System.out.print("Input number: ");
        Scanner sc = new Scanner(System.in);
        int inputNumber = 0;
        int count = 0;

        inputNumber = sc.nextInt();

        while (count < inputNumber) {
            System.out.println(count * 2);
            count++;
        }
    }

    public static void Exercice2() {
        //Console N sequence y M number
        Scanner sc = new Scanner(System.in);
        System.out.print("Input sequence: ");
        int inputSequence = sc.nextInt();
        System.out.print("Input number: ");
        int inputNumber = sc.nextInt();

        int count = 0;

        while (count < inputSequence) {
            System.out.println(count * inputNumber);
            count++;
        }
    }

    public static void Exercice3() {
        //Validate prime number
        System.out.print("Input number to validate: ");
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();
        boolean isPrime = true;

        for (int i = 1; i <= (inputNumber / 2); i++) {
            if (inputNumber % i == 0 && i != 1) {
                System.out.println("Es multipo de " + i);
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Es primo");
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 1; i <= (number / 2); i++)
            if (number % i == 0 && i != 1) return false;
        return true;
    }

    //Bugfix
    public static void Exercice4() {
        System.out.println("Input sequence");
        Scanner sc = new Scanner(System.in);

        int sequence = sc.nextInt();
        int prime = 1;
        boolean existPrime = false;
        String primes = "";

        while (sequence > 0) {
            while (!existPrime) {
                if (isPrime(prime)) {
                    existPrime = true;
                    primes += prime;
                }
                prime++;
            }
            existPrime = false;
            sequence--;
        }
        System.out.println(primes);
    }

    public static void Exercice5() {
        System.out.print("Input sequence: ");
        Scanner sc = new Scanner(System.in);
        int sequence = sc.nextInt();
        System.out.println("Input min digit: ");
        int minDigit = sc.nextInt();
        System.out.println("Input digit: ");
        int digit = sc.nextInt();

        int number = 0;
        boolean existDigit = false;

        while (sequence > 0) {
            sequence--;
        }
    }


    public static void radixSort(int []arr)
    {
        //Implementación
        String[] results = toStringArray(arr);
        lNormalize(results,'0');
        HashMap<String,ArrayList<String>> mapListas = new HashMap<String,ArrayList<String>>();

        for (int i = 0; i < 10; i++){
            mapListas.put("L"+i, new ArrayList<String>());
        }

        int maxLength = maxLength(results);

        while (maxLength > 0) {
            for (int i = 0; i < results.length; i++){
                char charValue = results[i].charAt(maxLength-1);

                ArrayList<String> values = mapListas.get("L"+charValue);
                values.add(results[i]);
                mapListas.put("L"+charValue, values);
            }
            //Chequear listas y volver a crear lista base
            ArrayList<String> temp = new ArrayList<String>();
            for (Map.Entry<String, ArrayList<String>> entry:mapListas.entrySet()){
                String key = entry.getKey();
                ArrayList<String> value = entry.getValue();

                temp.addAll(value);
                mapListas.put(key, new ArrayList<String>());
            }
            results = temp.toArray(String[]::new);

            maxLength--;
        }
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String result = "";
        for(int i = 0; i < n; i++) {
            result += c;
        }
        return result;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        int length = s.length();

        String prefix = replicate(c,  n - length);
        return prefix + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] aNumbers = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            aNumbers[i] = Integer.toString(arr[i]);
        }
        return aNumbers;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] aNumbers = new int[arr.length];

        for (int i = 0;i < arr.length; i++){
            aNumbers[i] = Integer.parseInt(arr[i]);
        }

        return aNumbers;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > maxLength)
                maxLength = arr[i].length();
        }

        return maxLength;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int length = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], length, c);
        }
    }
}