//Desarrollar un programa para mostrar por consola los primeros n números naturales que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
//Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola los primeros 5 números naturales que tienen, al menos, 2 dígitos 3. En este caso la salida será: 33, 133, 233, 303, 313.
//Según cómo decidas encarar la solución de este ejercicio, es probable que necesites utilizar recursos que aún no hemos estudiado. El desafío consiste en googlear cómo utilizar dichos recursos y ¡utilizarlos!

package com.ejercicio5;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        System.out.println("Ejercicio 2");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros que quiere");
        int numberQuantityDesired = scanner.nextInt();
        System.out.println("Ingrese el digito que quiere incluir");
        int includeNumber = scanner.nextInt();
        System.out.println("Y cuantos de ellos quiere");
        int includeNumberQuantity = scanner.nextInt();

        int currentNumber = Integer.parseInt((includeNumber +"").repeat(includeNumberQuantity));
        StringBuilder currentString = new StringBuilder('0'+String.valueOf(currentNumber));
        int replacePosition = 0;
        int replaceNumber = 0;

        for (int i = 0; i <numberQuantityDesired - 1; i++) {
            if (replaceNumber == 9){
                currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                System.out.print(currentString + ", ");
                i++;
                if (replacePosition == 0){
                    replaceNumber++;
                    currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                    currentString.insert(0,"1");
                    replacePosition++;
                    replaceNumber++;
                }else if (intAt(currentString, replacePosition-1)==includeNumber){
                    currentString.replace(replacePosition,replacePosition+1, String.valueOf(includeNumber));
                    replacePosition--;
                    replaceNumber = intAt(currentString, replacePosition)+1;
                    currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                    replaceNumber++;
                }else{
                    replaceNumber++;
                    currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                    replacePosition--;
                    currentString.replace(replacePosition,replacePosition+1, String.valueOf(intAt(currentString, replacePosition)+1));
                    if (intAt(currentString, replacePosition) != includeNumber){
                        replacePosition++;
                        replaceNumber++;
                    } else {
                        replacePosition = currentString.length()-1;
                        replaceNumber = includeNumber + 1;
                    }

                }

            } else if (replaceNumber%10 != includeNumber){
                currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                replaceNumber++;
            }else if(replacePosition != currentString.length() - 1){
                currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                replacePosition++;
                replaceNumber = 0;
                currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                replaceNumber ++;
            }else{
                replaceNumber++;
                currentString.replace(replacePosition,replacePosition+1, String.valueOf(replaceNumber%10));
                replaceNumber++;
            }

            System.out.print(currentString + ", ");
        }

    }

    public static int intAt(StringBuilder string, int position){
        return Integer.parseInt(String.valueOf(string.charAt(position)));
    }
}


