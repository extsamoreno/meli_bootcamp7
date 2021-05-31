package tm;

import java.util.Scanner;

public class Ejcio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número, del cual quiera conocer sus múltiplos: ");
        int number = scanner.nextInt();

        System.out.println("Ahora ingrese la cantidad de múltiplos de ese número que quiera mostrar: ");
        int numberOfMultiples = scanner.nextInt();

        int thisNumber;
        int counter = 1;

        for (int i = 0; i < numberOfMultiples; i++) {
            thisNumber = number * counter;
            System.out.println(thisNumber);
            counter ++;
        }
    }
}