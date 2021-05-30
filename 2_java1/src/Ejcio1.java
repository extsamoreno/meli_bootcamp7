import java.util.Scanner;

public class Ejcio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número para obtener esa cantidad de números pares: ");
        int number = scanner.nextInt();

        System.out.println("Los primeros " + number + " números pares son:");

        int thisNumber = 0;

        for (int i = 0; i < number; i++) {
            System.out.println(thisNumber);
            thisNumber = thisNumber + 2;
        }
    }
}