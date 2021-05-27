package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr ={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }

    public static void Exercise1() {
        System.out.print("Input number: ");
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();

        for (int i = 0; i < inputNumber; i++) {
            System.out.println(i * 2);
        }
    }

    public static void Exercise2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input sequence: ");
        int inputSequence = sc.nextInt();
        System.out.print("Input number: ");
        int inputNumber = sc.nextInt();

        for (int i = 0; i < inputSequence; i++) {
            System.out.println(i * inputNumber);
        }
    }

    public static void Exercise3() {
        //Validate prime number
        System.out.print("Input number to validate: ");
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();

        if (isPrime(inputNumber)) {
            System.out.println("Es primo");
        } else {
            System.out.println("NO es primo");
        }
    }

    public static boolean isPrime(int number) {
        //if (number == 0) throw new Exception("0 no es par ni compuesto");

        for (int i = 1; i <= (number / 2); i++) {
            if (number % i == 0 && i != 1) return false;
        }

        return true;
    }

    public static void Exercise4() {
        System.out.println("Input sequence");
        Scanner sc = new Scanner(System.in);

        int sequence = sc.nextInt();
        int prime = 1;
        String primes = "";

        while (sequence > 0) {
            while (!isPrime(prime)) {
                prime++;
            }
            primes += " " + prime;
            prime++;
            sequence--;
        }
        System.out.println(primes);
    }

    public static void Exercise5() {
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

    //region Exercise 6 RadixSort
    public static void radixSort(int []arr)
    {
        String[] results = toStringArray(arr);
        HashMap<String,ArrayList<String>> mapLists = new HashMap<>();

        lNormalize(results,'0');
        int maxLength = maxLength(results);

        for (int i = 0; i < 10; i++){
            mapLists.put("L"+i, new ArrayList<String>());
        }

        while (maxLength > 0) {
            for (int i = 0; i < results.length; i++){
                char charValue = results[i].charAt(maxLength-1);

                ArrayList<String> values = mapLists.get("L"+charValue);
                values.add(results[i]);
                mapLists.put("L"+charValue, values);
            }

            ArrayList<String> temp = new ArrayList<String>();

            for (Map.Entry<String, ArrayList<String>> entry:mapLists.entrySet()){
                String key = entry.getKey();
                ArrayList<String> value = entry.getValue();

                temp.addAll(value);
                mapLists.put(key, new ArrayList<String>());
            }
            results = temp.toArray(String[]::new);

            maxLength--;
        }

        System.arraycopy(toIntArray(results), 0, arr, 0, results.length);
    }

    public static String replicate(char c,int n)
    {
        String result = "";
        for(int i = 0; i < n; i++) {
            result += c;
        }
        return result;
    }

    public static String lpad(String s,int n,char c)
    {
        int length = s.length();

        String prefix = replicate(c,  n - length);

        return prefix + s;
    }

    public static String[] toStringArray(int arr[])
    {
        String[] aNumbers = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            aNumbers[i] = Integer.toString(arr[i]);
        }

        return aNumbers;
    }

    public static int[] toIntArray(String arr[])
    {
        int[] aNumbers = new int[arr.length];

        for (int i = 0;i < arr.length; i++){
            aNumbers[i] = Integer.parseInt(arr[i]);
        }

        return aNumbers;
    }

    public static int maxLength(String arr[])
    {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > maxLength)
                maxLength = arr[i].length();
        }

        return maxLength;
    }

    public static void lNormalize(String arr[],char c)
    {
        int length = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], length, c);
        }
    }
    //endregion
}
