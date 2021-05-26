package Parte1;

import java.util.ArrayList;
import java.util.Scanner;

public class naturales {

    public static void natural(int n, int m, int d){

        // Aquí se irán agregando los números
        ArrayList <Integer> array = new ArrayList<>();


        int inicio = (int) Math.pow(10, m - 1);

        while (array.size() != n) {

            String numstr = String.valueOf(inicio);
            char[] ch = numstr.toCharArray();

            // Verificar cuantas veces se repiten los digitos
            int  count = 0;
            for (int i = 0; i < ch.length ; i++) {
                int num = Character.getNumericValue(ch[i]);
                if (num == d){
                    count++;
                }
            }
            if(count == m){
                array.add(inicio);
            }
            inicio++;
        }
        for (Integer integer: array) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        System.out.print("How many numbers?: ");
        int howManyNum = scanner.nextInt();
        System.out.print("How many digits: ");
        int digits     = scanner.nextInt();
        System.out.print("What number? ");
        int num   = scanner.nextInt();
        natural(howManyNum, digits, num);
    }
}
