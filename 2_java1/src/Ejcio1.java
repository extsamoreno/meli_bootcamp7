import java.util.Scanner;

public class Ejcio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese un número: ");
        int number = scanner.nextInt();

        int thisNumber = 0;

        for (int i = 0; i < number; i++) {
            System.out.println(thisNumber);
            thisNumber = thisNumber + 2;
        }
    }
}