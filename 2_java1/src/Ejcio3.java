import java.util.Scanner;

public class Ejcio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

            System.out.println("Por favor ingrese un número, para saber si este número es primo o no:");
            int number = scanner.nextInt();

            if (isPrimo(number)) {
                System.out.println("El número " + number + " ES un número primo");
            } else
                System.out.println("El número " + number + " NO ES un número primo");
    }

    public static boolean isPrimo(int number) {

        if (number != 2 && number % 2 == 0)
            return false;

        int counter = 2;
        boolean isPrimo = true;

        while (isPrimo && counter != number) {
            if ((number % counter) == 0) {
                isPrimo = false;
            }
            counter++;
        }

        return isPrimo;
    }
}