import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa un número");
        int numero = scanner.nextInt();
        int m = 1, i = 0;
        while (i < numero) {
            if (m % 2 == 0) {
                System.out.print(m + " ");
                i++;
            }
            m++;
        }
    }
}
