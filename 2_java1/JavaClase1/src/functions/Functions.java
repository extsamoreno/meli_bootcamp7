package functions;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.function.Function;

public class Functions {

    public static int askNumber(String message){
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        return userInput.nextInt();
    }

    public static Integer[] getNNumbers(int n) {
        Integer[] numbers = new Integer[n];
        int number = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = number;
            number += 1;
        }
       return numbers;
    }
    public static Integer[] getNNumbers(int n, int m) {
        Integer[] numbers = new Integer[n];
        int number = 0;
        for (int i = 0; i < n; i++) {
           numbers[i] = number;
           number += m;
        }
        return numbers;
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

        for (int i = 2; i < num/2; i++){
            if (num%i == 0) {
                output = false;
                break;
            }
        }

        if (num == 4){
            output = false;
        }

        return output;
    }

    public static int getPrimeNum(){
        int num = 1;
        while (!isPrimeNumber(num)){
            num++;
        }
        return num;
    }

    public static int getPrimeNum(int start){
        int num = start;
        while (!isPrimeNumber(num)){
            num++;
        }
        return num;
    }

    public static Integer[] getNPrimeNums(int n) {
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[i] = Functions.getPrimeNum();
            } else {
                nums[i] = Functions.getPrimeNum(nums[i - 1] + 1);
            }
        }
        return nums;
    }

    public static <T> void printArray (T t[]){
        for (T n:
                t) {
            System.out.println(n);
        }
    }
}
