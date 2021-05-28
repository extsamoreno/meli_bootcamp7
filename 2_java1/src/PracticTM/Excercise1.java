package PracticTM;

import java.util.Scanner;

public class Excercise1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese n");
        int n = sc.nextInt();
        int i=0;
        do{
            System.out.println(i*2);
            i++;
        } while (i<n);
    }
}
