package com.meli;
//Ejercicio correspondiente a la Clase 1 Java jornada tarde
public class ej5 {
    import java.util.Collections;
import java.util.Scanner;

    public class Ej5 {

    /*
    Desarrollar un programa para mostrar por consola los primeros n números naturales
    que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
    Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola los
    primeros 5 números naturales que tienen, al menos, 2 dígitos 3.
    En este caso la salida será: 33, 133, 233, 303, 313.
    Según cómo decidas encarar la solución de este ejercicio, es probable que necesites
    utilizar recursos que aún no hemos estudiado. El desafío consiste en googlear cómo utilizar
    dichos recursos y ¡utilizarlos!
    */

        public static void main (String[] args) {

            int n, m, d;
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            m = in.nextInt();
            d = in.nextInt();

            findNNumber(n, m, d);

            in.close();

        }

        public static void findNNumber(int n, int m, int d) {

            int multiplier;
            int number = 0;
            String digits = "1";
            digits = digits + String.join("", Collections.nCopies(m-1, "0"));
            multiplier = Integer.parseInt(digits);
            // multiplier me hace saltearme N números que tienen menor cantidad de digitos
            // de los que me pide encontrar en el número

            if(number < multiplier) {
                number = multiplier;
            }

            for(int i = 0 ; i < n ; i++) {
                number = findMDNumber(number, m, d);
                number++;
            }

        }

        public static int findMDNumber(int n, int m, int d) {

            String stringNumber = Integer.toString(n);
            char digit = Integer.toString(d).charAt(0);
            int count = 0;
            boolean notFound = true;

            while(notFound) {
                for(int i = 0 ; i < stringNumber.length() ; i++) {
                    if(digit == stringNumber.charAt(i)) {
                        count++;
                        if(count >= m) {
                            System.out.println(n);
                            return n;
                        }
                    }
                }
                count = 0;
                n++;
                stringNumber = Integer.toString(n);
            }

            return n;

        }

    }
}
