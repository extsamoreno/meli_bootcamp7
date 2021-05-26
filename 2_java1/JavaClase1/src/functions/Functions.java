package functions;

import java.util.Scanner;

public class Functions {

    public static int askNumber(String message){
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        return userInput.nextInt();
    }

    public static void printNNumbers(int n, int m) {
        int number = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(number);
            number += m;
        }
    }

    public static void printIsPrimeNumber(int num){
        if (isPrimeNumber(num)){
            System.out.println("El número " + num + " es primo.");
        }
        else{
            System.out.println("El número " + num + " no es primo.");
        }
    }

    public static boolean isPrimeNumber(int num){
        boolean output = true;
        for (int i = 2; i < Math.sqrt(num); i++){
            if (num%i == 0) {
                output = false;
                break;
            }
        }
        return output;
    }

}
