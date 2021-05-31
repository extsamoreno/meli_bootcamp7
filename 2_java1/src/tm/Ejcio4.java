package tm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejcio4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese la cantidad de números primos que quiera que se muestren:");
        int number = scanner.nextInt();

        System.out.println("Los primeros " + number + " números primos son los siguientes: " + getPrimeNumbers(number));

    }

    public static List<Integer> getPrimeNumbers(int number) {

        List<Integer> primeNumbers = new ArrayList<>();

        int counter = 0;

        for (int i = 0; counter < number; i++) {

            if (Ejcio3.isPrimo(i)) {
                primeNumbers.add(i);
                counter++;
            }
        }

        return primeNumbers;
    }
}
